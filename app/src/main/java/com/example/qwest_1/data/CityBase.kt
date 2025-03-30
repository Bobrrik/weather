package com.example.qwest_1.data

//data class CityBase(val name: String, val populism : Int) {
data class CityBase(val name: String, val status: String) {
    val cities = listOf(
        CityBase("Москва", "Большой"),
        CityBase("Алексеевка", "маленький"),
        CityBase("Воронеж", "средний"),
        CityBase("Тольяти", "средний"),
        CityBase("Новгород", "маленький")
    )
}

data class Season(val name: String) {
    val seasons = listOf("Осень", "Зима", "Весна", "Лето")
}