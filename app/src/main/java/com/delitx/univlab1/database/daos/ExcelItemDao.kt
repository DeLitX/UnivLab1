package com.delitx.univlab1.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.delitx.univlab1.data_classes.ExcelItem

@Dao
interface ExcelItemDao {
    @Query("select * from excelitem where name=:name")
    fun getItemByName(name:String):ExcelItem
    @Query("select * from excelitem where name in (:names)")
    fun getItemsByName(names:List<String>):List<ExcelItem>
    @Query("select * from excelitem")
    fun getAllItems():LiveData<List<ExcelItem>>
    @Query("select * from excelitem")
    fun getAllItemsValue():List<ExcelItem>
    @Query("delete from excelitem")
    fun deleteAll()
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(list:List<ExcelItem>)
    @Delete
    fun delete(list:List<ExcelItem>)
}