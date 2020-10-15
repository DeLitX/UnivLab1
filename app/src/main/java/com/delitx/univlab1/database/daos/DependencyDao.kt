package com.delitx.univlab1.database.daos

import androidx.room.*
import com.delitx.univlab1.data_classes.Dependency

@Dao
interface DependencyDao {
    @Query("select * from dependency where `from` in (:names)")
    fun getDependencies(names: List<String>): List<Dependency>

    @Query("select * from dependency where `to`in (:names)")
    fun getDependants(names: List<String>): List<Dependency>

    @Query("select `to` from dependency where `from` in (:names)")
    fun getDependenciesNames(names: List<String>): List<String>

    @Query("select `from` from dependency where `to`in (:names)")
    fun getDependantsNames(names: List<String>): List<String>

    @Query("delete from dependency where `from`in (:names)")
    fun deleteDependenciesByDependantsNames(names: List<String>)

    @Query("delete from dependency")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(list: List<Dependency>)

    @Delete
    fun delete(list: List<Dependency>)
}