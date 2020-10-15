package com.delitx.univlab1

import com.delitx.univlab1.data_classes.Dependency
import com.delitx.univlab1.data_classes.ExcelItem
import com.delitx.univlab1.database.ExcelDB

class Repository private constructor(private val mDatabase: ExcelDB) {
    private val mItemDao = mDatabase.getItemDao()
    private val mDependencyDao = mDatabase.getDependencyDao()
    val itemsList = mItemDao.getAllItems()

    companion object {
        private var mInstance: Repository? = null
        fun getInstance(database: ExcelDB): Repository {
            if (mInstance == null) {
                mInstance = Repository(database)
            }
            return mInstance!!
        }
    }
    suspend fun deleteItem(item:ExcelItem){
        mItemDao.delete(listOf(item))
        mDependencyDao.delete(mDependencyDao.getDependencies(listOf(item.name)))
    }
    suspend fun deleteDependenciesOfDependants(names:List<String>){
        mDependencyDao.deleteDependenciesByDependantsNames(names)
    }
    suspend fun saveItems(items: List<ExcelItem>) {
        mItemDao.insert(items)
    }

    suspend fun saveDependencies(list: List<Dependency>) {
        mDependencyDao.insert(list)
    }

    suspend fun getAllItems(): List<ExcelItem> {
        return mItemDao.getAllItemsValue()
    }

    suspend fun getItemsByNames(names: List<String>): List<ExcelItem> {
        return mItemDao.getItemsByName(names)
    }

    suspend fun getDependenciesNames(names: Set<String>): Set<String> {
        return mDependencyDao.getDependenciesNames(names.toMutableList()).toMutableSet()
    }

    suspend fun getDependantsNames(names: Set<String>): Set<String> {
        return mDependencyDao.getDependantsNames(names.toMutableList()).toMutableSet()
    }
}