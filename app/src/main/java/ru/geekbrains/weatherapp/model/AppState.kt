package ru.geekbrains.weatherapp.model

import ru.geekbrains.weatherapp.model.data.Weather

sealed class AppState {
    data class Success(val weatherData: List<Weather>) : AppState()
    class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
