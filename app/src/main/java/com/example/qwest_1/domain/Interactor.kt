package com.example.qwest_1.domain

import com.example.qwest_1.data.CityBase

class Interactor(val repo: CityBase) {
    fun getFilmsDB(): List<CityBase> = repo.cities
}