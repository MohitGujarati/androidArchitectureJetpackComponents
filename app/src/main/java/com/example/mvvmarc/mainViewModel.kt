package com.example.mvvmarc

import androidx.lifecycle.ViewModel

class mainViewModel(initalvalue:Int):ViewModel() {

    var count:Int=initalvalue


    fun increment(){
        count++
    }


}