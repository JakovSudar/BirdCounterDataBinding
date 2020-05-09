package com.example.birdcounterdatabinding


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    var counter = MutableLiveData<Int>()

    fun setCounter(newValue : Int){
        this.counter.value = newValue
    }
}