package ru.geekbrains.myweatherapp.model

class RepositoryLocalImpl : Repository {

    override fun getWeather(): Weather {
        TODO("Not yet implemented")
    }

    fun getWeatherFromLocalStorageRus(): List<Weather> {
        return getRussianCities()
    }

    fun getWeatherFromLocalStorageWorld(): List<Weather> {
        return getWorldCities()
    }

}