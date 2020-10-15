package com.delitx.univlab1.ui.activities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.delitx.univlab1.*
import com.delitx.univlab1.data_classes.ExcelItem
import com.delitx.univlab1.database.ExcelDB
import com.delitx.univlab1.ui.adapters.ExcelAdapter
import com.delitx.univlab1.view_models.ExcelViewModel
import com.delitx.univlab1.view_models.factories.ViewModelFactory
import com.google.android.material.textfield.TextInputEditText
import com.kelin.scrollablepanel.library.ScrollablePanel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var mExcel: ScrollablePanel
    private lateinit var mExcelAdapter: ExcelAdapter
    private lateinit var mQueryEditor: TextInputEditText
    private lateinit var mViewModel: ExcelViewModel
    private lateinit var mProcessingIndicator: ProgressBar
    private lateinit var mChoosenCellName: TextView
    private var mCurrentItem: ExcelItem? = null
    private var mExcelUnchooseLambda: (() -> Unit)? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindActivity()
        setupViewModel()
    }

    private fun setupViewModel() {
        mViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                application,
                Repository.getInstance(ExcelDB.getInstance(this.application))
            )
        ).get(ExcelViewModel::class.java)
        mViewModel.itemsLiveData.observe(this, Observer {
            mExcelAdapter.setData(it)
            mExcel.notifyDataSetChanged()
        })
    }

    private fun bindActivity() {
        mProcessingIndicator = processing_indicator
        mQueryEditor = extension_enter
        mChoosenCellName = choosen_cell_name
        info_icon.setOnClickListener {
            startActivity(Intent(this,InfoActivity::class.java))
        }
        mExcelAdapter = ExcelAdapter(object : ExcelAdapter.AdapterInterface {
            override fun onItemClick(item: ExcelItem, onUnchoose: () -> Unit) {
                onItemSelect(item, onUnchoose)
            }

            override fun notifyItemSelected(item: ExcelItem, onUnchoose: () -> Unit) {
                onItemSelect(item, onUnchoose)
            }

        })
        mExcel = content_container
        mExcel.setPanelAdapter(mExcelAdapter)
        mQueryEditor.setOnEditorActionListener { textView, i, keyEvent ->
            if (i == EditorInfo.IME_ACTION_DONE || i == EditorInfo.IME_ACTION_UNSPECIFIED) {
                handleExpression(mQueryEditor.text.toString())
                true
            } else {
                false
            }
        }
        button_enter.setOnClickListener {
            handleExpression(mQueryEditor.text.toString())
        }
    }
    private fun onItemSelect(item:ExcelItem,onUnchoose:()->Unit){
        mExcelUnchooseLambda?.let { it() }
        mExcelUnchooseLambda = onUnchoose
        mCurrentItem = item
        mQueryEditor.setText(item.query, TextView.BufferType.NORMAL)
        mExcelAdapter.selectedItemName = item.name
        mChoosenCellName.text=item.name+":"
    }

    private fun handleExpression(query: String) {
        if (mCurrentItem != null && query.trim() != "") {
            disableView()
            CoroutineScope(Default).launch {
                mCurrentItem!!.query = query
                val success =
                    mViewModel.evaluateQuery(mCurrentItem!!) {
                        CoroutineScope(IO).launch {
                            mViewModel.updateDependencies(
                                it
                            )
                        }
                    }
                if (success) {
                    mViewModel.saveItem(mCurrentItem!!)
                    withContext(Main) {
                        enableView()
                    }
                } else {
                    withContext(Main) {
                        showError()
                    }
                }
            }
        } else if (mCurrentItem != null && query.trim() == "" && mCurrentItem?.query != "") {
            mCurrentItem!!.query = ""
            mCurrentItem!!.value = 0.0
            CoroutineScope(Main).launch {
                disableView()
                withContext(IO) {
                    mViewModel.deleteItem(mCurrentItem!!)
                }
                enableView()
            }
        }
    }

    fun disableView() {
        mExcel.isEnabled = false
        mProcessingIndicator.visibility = View.VISIBLE
        mQueryEditor.isEnabled = false
    }

    fun enableView() {
        mExcel.isEnabled = true
        mProcessingIndicator.visibility = View.GONE
        mQueryEditor.isEnabled = true
    }

    fun showError() {
        AlertDialog.Builder(this@MainActivity).setTitle("Syntax error")
            .setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            }.setMessage("Your query is wrong.Please correct it.").create().show()
        enableView()
    }
}