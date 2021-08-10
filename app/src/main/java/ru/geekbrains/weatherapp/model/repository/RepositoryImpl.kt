package ru.geekbrains.weatherapp.model.repository

import ru.geekbrains.weatherapp.model.data.Weather
import ru.geekbrains.weatherapp.model.data.getRussianCities
import ru.geekbrains.weatherapp.model.data.getWorldCities

class RepositoryImpl : Repository {
    override fun getWeatherFromServer() = Weather()

    override fun getWeatherFromLocalStorageRus() = getRussianCities()

    override fun getWeatherFromLocalStorageWorld() = getWorldCities()
}