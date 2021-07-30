package ru.geekbrains.myweatherapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather(
    val city: City = getDefaultCity(),
    val temperature: Int = 0,
    val feelsLike: Int = 0
) : Parcelable

fun getDefaultCity() = City("Москва", 55.755826, 37.617299900000035)

fun getWorldCities() : List<Weather>{
    return listOf(
        Weather(City("Лондон", 51.5085300, -0.1257400)),
        Weather(City("Токио", 35.6895000, 139.6917100)),
        Weather(City("Нью-Йорк",40.7128000,  74.0060000)))
}

fun getRussianCities(): List<Weather> {
    return listOf(
        Weather(City("Москва", 55.755826, 37.617299900000035), 1, 2),
        Weather(City("Екатеринбург", 56.83892609999999, 60.60570250000001), 7, 8),
        Weather(City("Ростов-на-Дону", 47.2357137, 39.701505), 17, 18))
}