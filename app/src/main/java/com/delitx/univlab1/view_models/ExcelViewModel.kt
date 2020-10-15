package com.delitx.univlab1.view_models

import androidx.lifecycle.ViewModel
import com.delitx.univlab1.Repository
import com.delitx.univlab1.data_classes.Dependency
import com.delitx.univlab1.data_classes.ExcelItem
import com.delitx.univlab1.language_decryption.Evaluator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception

class ExcelViewModel(private val mRepository: Repository) : ViewModel() {
    val itemsLiveData = mRepository.itemsList
    private lateinit var itemsSet: MutableSet<ExcelItem>

    init {
        CoroutineScope(IO).launch {
            itemsSet = mRepository.getAllItems().toMutableSet()
        }
    }

    suspend fun updateDependencies(list: List<Dependency>) {
        if (list.isNotEmpty()) {
            mRepository.deleteDependenciesOfDependants(listOf(list[0].from))
            mRepository.saveDependencies(list)
        }
    }
    suspend fun deleteItem(item:ExcelItem){
        itemsSet.remove(item)
        mRepository.deleteItem(item)
        updateDependants(setOf(item.name))
    }

    suspend fun saveItem(item: ExcelItem) {
        addItems(listOf(item), itemsSet)
        mRepository.saveItems(listOf(item))
        updateDependants(setOf(item.name))
    }

    suspend fun saveItems(items: List<ExcelItem>) {
        addItems(items, itemsSet)
        mRepository.saveItems(items)
        val names = mutableSetOf<String>()
        for (i in items) {
            names.add(i.name)
        }
        updateDependants(names)
    }

    private suspend fun updateDependants(names: Set<String>): Boolean {
        return try {
            val dependantsNames = mRepository.getDependantsNames(names)
            val dependants: List<ExcelItem>? =
                mRepository.getItemsByNames(dependantsNames.toMutableList())
            if (dependants != null && dependants.isNotEmpty()) {
                for (i in dependants) {
                    if (!evaluateQuery(i) {}) {
                        return false
                    }
                }
                saveItems(dependants)
            }
            return true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun evaluateQuery(item: ExcelItem, doAfter: (List<Dependency>) -> Unit): Boolean {
        val evaluator = Evaluator(item, object : Evaluator.EvaluateHelper {
            override suspend fun getClassesFromDb(list: Set<String>): Set<ExcelItem> {
                return mRepository.getItemsByNames(list.toMutableList()).toMutableSet()
            }

            override suspend fun getDependenciesByNames(list: Set<String>): Set<String> {
                return mRepository.getDependenciesNames(list)
            }

            override fun getLinkValue(link: String): Double {
                return itemsSet.find { it.name == link }?.value ?: 0.0
            }

        })
        return try {
            item.value = evaluator.evaluate()
            doAfter(evaluator.getListOfDependencies())
            true
        } catch (ex: IllegalArgumentException) {
            false
        }
    }

    private fun addItems(items: List<ExcelItem>, set: MutableSet<ExcelItem>) {
        for (i in items) {
            while (true) {
                if (!set.remove(set.findLast { it.name == i.name })) {
                    break
                }
            }
        }
        set.addAll(items)
    }

}