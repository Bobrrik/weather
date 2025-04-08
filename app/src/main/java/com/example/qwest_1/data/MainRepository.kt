package com.example.qwest_1.data

import com.example.qwest_1.domain.City


class MainRepository {
    val citiesDataBase = listOf(
        City("Москва", 12),
        City("Алексеевка", 3000),
        City("Воронеж", -30),
        City("Тольяти", 212),
        City("Новгород", 10000)
    )
}