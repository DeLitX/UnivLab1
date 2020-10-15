package com.delitx.univlab1.data_classes

import androidx.room.Entity

@Entity(primaryKeys = ["from","to"])
data class Dependency(var from:String,var to:String) {
}