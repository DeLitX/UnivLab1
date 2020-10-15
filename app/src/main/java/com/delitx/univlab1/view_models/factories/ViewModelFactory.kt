package com.delitx.univlab1.view_models.factories

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.delitx.univlab1.Repository
import com.delitx.univlab1.view_models.ExcelViewModel

class ViewModelFactory(app:Application,val repository: Repository):ViewModelProvider.AndroidViewModelFactory(app) {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ExcelViewModel(repository) as T
    }
}