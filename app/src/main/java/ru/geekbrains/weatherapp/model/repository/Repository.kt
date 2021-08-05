package ru.geekbrains.weatherapp.model.repository

import ru.geekbrains.weatherapp.model.data.Weather

interface Repository {
    fun getWeatherFromServer(): Weather
    fun getWeatherFromLocalStorage(): Weather
}