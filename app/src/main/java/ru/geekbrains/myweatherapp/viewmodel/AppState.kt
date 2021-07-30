package ru.geekbrains.myweatherapp.viewmodel

import ru.geekbrains.myweatherapp.model.Weather

sealed class AppState {

    data class Error(val error : Throwable) : AppState()
    data class Success(val weatherData : List<Weather>) : AppState()
    object Loading : AppState()
}