package com.example.qwest_1.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qwest_1.data.CityBase
import com.example.qwest_1.domain.Interactor

class HomeFragmentViewModel : ViewModel() {
    val cityListLiveData = MutableLiveData<List<CityBase>>()
    private lateinit var interactor: Interactor
    init {
        //TODO init interactor

        val city = interactor.getFilmsDB()
        cityListLiveData.postValue(city)
    }
}