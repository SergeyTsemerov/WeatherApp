package ru.geekbrains.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.weatherapp.model.AppState
import ru.geekbrains.weatherapp.model.repository.Repository
import ru.geekbrains.weatherapp.model.repository.RepositoryImpl
import java.lang.Thread.sleep

class MainViewModel(private val repository: Repository = RepositoryImpl()) : ViewModel() {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()

    fun getData(): LiveData<AppState> {
        return liveDataToObserve
    }

    fun getWeatherFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(AppState.Success(repository.getWeatherFromLocalStorage()))
        }.start()
    }

    fun getWeatherFromRemoteSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(2000)
            liveDataToObserve.postValue(AppState.Success(repository.getWeatherFromServer()))
        }.start()
    }
}