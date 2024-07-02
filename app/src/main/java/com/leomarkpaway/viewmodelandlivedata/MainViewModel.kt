package com.leomarkpaway.viewmodelandlivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _counter = MutableLiveData<Int>(0)
    val counter: LiveData<Int> = _counter

    fun increment() {
        _counter.value = (_counter.value ?: 0) + 1
    }

    fun reset() {
        _counter.value = 0
    }

    fun decrement() {
        _counter.value= (_counter.value ?: 0) - 1
    }

}