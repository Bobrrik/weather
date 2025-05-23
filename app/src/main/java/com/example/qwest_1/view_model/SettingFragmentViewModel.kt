package com.example.qwest_1.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qwest_1.data.MainRepository

class SettingFragmentViewModel : ViewModel() {
    val cityNameList = MutableLiveData<MutableList<String>>()
    val base = MainRepository().citiesDataBase

    fun listFill() {
        val spinnerList = mutableListOf<String>() // лист для адаптера

        for (i in 0..base.size - 1) {   // заполнение листа для адаптера
            spinnerList.add(base[i].name)
        }
        cityNameList.postValue(spinnerList)
    }
    //fun fff()
}