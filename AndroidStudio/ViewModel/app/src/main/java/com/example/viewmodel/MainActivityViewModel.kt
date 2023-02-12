package com.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
//    var count = 0
    //mutable live data is a type of a data that can be edited

    var count = MutableLiveData<Int>()
    //use init block for initial value of the count
    init {
        count.value = 0
    }
    fun updateCount() {
//        count += 1
        //add safe operator to avoid null point exception
        count.value = (count.value)?.plus(1)

    }
}