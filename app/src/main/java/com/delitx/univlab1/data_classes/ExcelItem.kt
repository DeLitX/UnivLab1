package com.delitx.univlab1.data_classes

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class ExcelItem(
    @PrimaryKey
    var name: String,
    var query: String = "",
    var value: Double = 0.0
)