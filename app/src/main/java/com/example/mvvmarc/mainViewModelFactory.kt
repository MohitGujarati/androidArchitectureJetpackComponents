package com.example.mvvmarc

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel

class mainViewModelFactory(val counter:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return mainViewModel(counter) as T
    }
}
