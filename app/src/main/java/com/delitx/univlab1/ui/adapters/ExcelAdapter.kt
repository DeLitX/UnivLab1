package com.delitx.univlab1.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delitx.univlab1.R
import com.delitx.univlab1.algorithms.ExcelGridUtils
import com.delitx.univlab1.data_classes.ExcelItem
import com.kelin.scrollablepanel.library.PanelAdapter
import kotlinx.android.synthetic.main.item.view.*
import java.lang.Exception

class ExcelAdapter(private val mInterface: AdapterInterface) : PanelAdapter() {
    private var mList: List<ExcelItem> = listOf()
    private val TOP_LEFT = 0
    private val TOP = 1
    private val LEFT = 2
    private val MAIN = 3
    var selectedItemName: String = ""
    override fun getRowCount(): Int {
        return Int.MAX_VALUE
    }

    fun setData(list: List<ExcelItem>) {
        mList = list
    }

    override fun getColumnCount(): Int {
        return Int.MAX_VALUE
    }

    override fun getItemViewType(row: Int, column: Int): Int {
        return if (row == 0 && column == 0) {
            TOP_LEFT
        } else if (row == 0) {
            TOP
        } else if (column == 0) {
            LEFT
        } else {
            MAIN
        }
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder?, row: Int, column: Int) {
        if (p0 is MainViewHolder) {
            val item = mList.find {
                it.name == ExcelGridUtils.encodeName(column, row)
            }
            if (item == null) {
                val name = ExcelGridUtils.encodeName(
                    column,
                    row
                )
                p0.bind(
                    ExcelItem(
                        name, ""
                    ), false, name == selectedItemName
                )
            } else {
                p0.bind(
                    item, true, item.name == selectedItemName
                )
            }
        } else if (p0 is LeftViewHolder) {
            p0.bind(row)
        } else if (p0 is TopViewHolder) {
            p0.bind(column)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item, parent, false)
        return when (viewType) {
            TOP -> TopViewHolder(view)
            LEFT -> LeftViewHolder(view)
            MAIN -> MainViewHolder(view, mInterface)
            else -> EmptyViewHolder(view)
        }
    }


    class TopViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        fun bind(position: Int) {
            v.text.text = ExcelGridUtils.numberToString(position)
        }
    }

    class LeftViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        fun bind(position: Int) {
            v.text.text = position.toString()
        }
    }

    class MainViewHolder(private val v: View, private val mInterface: AdapterInterface) :
        RecyclerView.ViewHolder(v) {
        private var mItem: ExcelItem? = null

        init {
            v.setOnClickListener {
                if (mItem != null) {
                    mInterface.onItemClick(mItem!!) {
                        try {
                            v.text.setBackgroundColor(v.resources.getColor(R.color.colorWhite))
                        } catch (e: Exception) {

                        }
                    }
                }
                v.text.setBackgroundColor(v.resources.getColor(R.color.colorChoosen))
            }
        }

        fun bind(item: ExcelItem, showValue: Boolean, isSelected: Boolean) {
            mItem = item
            v.text.text = if (showValue) {
                item.value.toString()
            } else {
                ""
            }
            v.text.setBackgroundColor(v.resources.getColor(if (isSelected) R.color.colorChoosen else R.color.colorWhite))
            if (isSelected) {
                mInterface.notifyItemSelected(item) {
                    try {
                        v.text.setBackgroundColor(v.resources.getColor(R.color.colorWhite))
                    } catch (e: Exception) {

                    }
                }
            }
        }
    }

    class EmptyViewHolder(private val v: View) : RecyclerView.ViewHolder(v)
    interface AdapterInterface {
        fun onItemClick(item: ExcelItem, onUnchoose: () -> Unit)
        fun notifyItemSelected(item: ExcelItem, onUnchoose: () -> Unit)
    }
}