package com.example.qwest_1.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel : ViewModel() {         // переменные для передачи данных
    val city: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val season: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}