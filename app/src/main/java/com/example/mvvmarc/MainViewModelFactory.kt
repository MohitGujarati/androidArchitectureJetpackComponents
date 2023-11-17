package com.example.mvvmarc

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel

class MainViewModelFactory(val counter:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return MainViewModel(counter) as T
    }
}
