package com.example.qwest_1.data

import com.example.qwest_1.domain.City


class MainRepository {
    val citiesDataBase = mutableListOf(         //список всех городов
        City("Москва", 1200000,11,11,11,11,11),
        City("Алексеевка", 3000,9,9,9,9,9,9,9,),
        City("Воронеж", 30),
        City("Тольяти", 212),
        City("Новгород", 10000)
    )
}