package com.example.mvvmarc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class MainViewModel(initialValue: Int) : ViewModel() {

    private val EOTextDataObject = MutableLiveData<textDataModel>(textDataModel("Its Zero",initialValue))
    val ViewDataModel = MutableLiveData<textDataModel>()

    val EOTextLiveData: LiveData<String> get() = EOTextDataObject.map {
        it.textData
    }

    val EOtwoway = MutableLiveData<String>()



    var count: Int = initialValue

    init {
        // Initialize ViewDataModel
        updateViewDataModel()
    }

    fun increment() {
        count++
        updateViewDataModel()
        checkCount()
    }

    private fun checkCount() {
        if (count % 2 == 0) {
            EOTextDataObject.value = textDataModel("Its Even", count)
        } else {
            EOTextDataObject.value = textDataModel("Its Odd", count)
        }
    }

    private fun updateViewDataModel() {
        ViewDataModel.value = textDataModel( "Custom input", count)
        EOtwoway.value = "Custom input $count"
    }
}