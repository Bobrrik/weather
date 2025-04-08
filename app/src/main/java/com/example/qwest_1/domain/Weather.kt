package com.example.qwest_1.domain

import android.graphics.Color

data class Weather(
    val name: String,
    val status: String,
    val season: String,
    val m1_name: String,
    val m1_temp: Int,
    val m2_name: String,
    val m2_temp: Int,
    val m3_name: String,
    val m3_temp: Int,
) {
    val temp = (m1_temp + m2_temp + m3_temp) / 3
    val colorSeason = {
        when (season) {
            "Лето" -> Color.GREEN
            "Весна" -> Color.YELLOW
            "Осень" -> Color.rgb(255, 127, 80) // оранжевый
            "Зима" -> Color.WHITE  // Зима
            else -> Color.GRAY
        }

    }
}
//Январь. 1
//Февраль. 1
//Март. 1
//Апрель. 1
//Май. 1
//Июнь. 1
//Июль. 1
//Август. 1
//Сентябрь. 1
//Октябрь. 1
//Ноябрь. 1
//Декабрь. 1
//Сезоны года и соответствующие им месяцы:
//
//Зима — декабрь, январь, февраль. 25
//Весна — март, апрель, май. 25
//Лето — июнь, июль, август. 25
//Осень — сентябрь, октябрь, ноябрь. 25