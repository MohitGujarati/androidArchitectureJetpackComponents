package com.example.mvvmarc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class mainViewModel(initalvalue:Int):ViewModel() {

   private var numberDataObject=MutableLiveData<String>("Its Zero")

    val numberLiveData:LiveData<String>
        get() =numberDataObject

    var count:Int=initalvalue


    fun increment(){
        count++
        checkCount()
    }

    private fun checkCount() {
        if (count%2==0){
            numberDataObject.value="Its Even"
        }else{
            numberDataObject.value="Its Odd"
        }
    }


}