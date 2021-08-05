package ru.geekbrains.myweatherapp.model

class RepositoryLocalImpl : Repository {

    override fun getWeather(): Weather = Weather()

    fun getWeatherFromLocalStorageRus(): List<Weather> =  getRussianCities()


    fun getWeatherFromLocalStorageWorld(): List<Weather> = getWorldCities()

}