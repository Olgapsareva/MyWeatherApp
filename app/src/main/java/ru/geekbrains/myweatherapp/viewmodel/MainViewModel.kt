package ru.geekbrains.myweatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.myweatherapp.model.Repository
import ru.geekbrains.myweatherapp.model.RepositoryLocalImpl

class MainViewModel () : ViewModel() {

    private val liveDataToObserve : MutableLiveData<AppState> = MutableLiveData()
    private val repositoryImpl = RepositoryLocalImpl()

    fun getWeatherFromLocalSourceRus() = getDataFromLocalSource(isRussian = true)
    fun getWeatherFromLocalSourceWorld() = getDataFromLocalSource(isRussian = false)

    fun getWeatherFromRemoteSource() = getDataFromLocalSource(isRussian = true)

    private fun getDataFromLocalSource(isRussian: Boolean) {
        liveDataToObserve.value = AppState.Loading
        Thread{
            Thread.sleep(2000)
            liveDataToObserve.postValue(AppState.Success(if (isRussian) repositoryImpl.getWeatherFromLocalStorageRus()
            else repositoryImpl.getWeatherFromLocalStorageWorld()))
        }.start()
    }

    fun getLiveData() = liveDataToObserve
}