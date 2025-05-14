package com.example.qwest_1.domain

import kotlin.random.Random

data class City(
    val name: String,
    var populism: Int,
    val moTemp_1: Int = random_temp(),
    val moTemp_2: Int = random_temp(),
    val moTemp_3: Int = random_temp(),
    val moTemp_4: Int = random_temp(),
    val moTemp_5: Int = random_temp(),
    val moTemp_6: Int = random_temp(),
    val moTemp_7: Int = random_temp(),
    val moTemp_8: Int = random_temp(),
    val moTemp_9: Int = random_temp(),
    val moTemp_10: Int = random_temp(),
    val moTemp_11: Int = random_temp(),
    val moTemp_12: Int = random_temp()
) {
    var size = {
        if (populism < 0) populism = 0

        when (populism) {
            in 0..9999 -> "Маленький"
            in 10000..499999 -> "Средний"
            else -> "Большой"
        }
    }

    fun quarterName(season: String, quarter: Int): String {
        var month = "месяц не найден"
        when (season) {
            "Зима" -> {
                when (quarter) {
                    1 -> month = "Декабрь"
                    2 -> month = "Январь"
                    3 -> month = "Февраль"

                }
            }

            "Весна" -> {
                when (quarter) {
                    1 -> month = "Март"
                    2 -> month = "Апрель"
                    3 -> month = "Май"
                }
            }

            "Лето" -> {
                when (quarter) {
                    1 -> month = "Июнь"
                    2 -> month = "Июль"
                    3 -> month = "Август"
                }
            }

            "Осень" -> {
                when (quarter) {
                    1 -> month = "Сентябрь"
                    2 -> month = "Октябрь"
                    3 -> month = "Ноябрь"
                }
            }
        }
        return month
    }

    fun quarterTemp(season: String, quarter: Int): Int {
        var month = 0
        when (season) {
            "Зима" -> {
                when (quarter) {
                    1 -> month = moTemp_12
                    2 -> month = moTemp_1
                    3 -> month = moTemp_2
                }
            }

            "Весна" -> {
                when (quarter) {
                    1 -> month = moTemp_3
                    2 -> month = moTemp_4
                    3 -> month = moTemp_5
                }
            }

            "Лето" -> {
                when (quarter) {
                    1 -> month = moTemp_6
                    2 -> month = moTemp_7
                    3 -> month = moTemp_8
                }
            }

            "Осень" -> {
                when (quarter) {
                    1 -> month = moTemp_9
                    2 -> month = moTemp_10
                    3 -> month = moTemp_11
                }
            }
        }
        return month
    }
}

private fun random_temp(): Int {
    val temp = Random.nextInt(-30, 30)
    return temp
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