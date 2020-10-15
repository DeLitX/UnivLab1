package com.delitx.univlab1.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.delitx.univlab1.data_classes.Dependency
import com.delitx.univlab1.data_classes.ExcelItem
import com.delitx.univlab1.database.daos.DependencyDao
import com.delitx.univlab1.database.daos.ExcelItemDao

@Database(entities = [ExcelItem::class,Dependency::class], version = 1, exportSchema = false)
abstract class ExcelDB : RoomDatabase() {
    companion object {
        private var mInstance: ExcelDB? = null
        fun getInstance(application: Application): ExcelDB {
            if (mInstance == null) {
                mInstance = Room.databaseBuilder(application, ExcelDB::class.java, "excel_db")
                    .fallbackToDestructiveMigration().build()
            }
            return mInstance!!
        }
    }
    abstract fun getItemDao():ExcelItemDao
    abstract fun getDependencyDao():DependencyDao
}