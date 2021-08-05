package ru.geekbrains.myweatherapp.model

interface Repository {
    fun getWeather(): Weather
    /*fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalStorageRus(): List<Weather>
    fun getWeatherFromLocalStorageWorld(): List<Weather>*/
}