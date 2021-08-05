package ru.geekbrains.weatherapp.model.repository

import ru.geekbrains.weatherapp.model.data.Weather

class RepositoryImpl : Repository {
    override fun getWeatherFromServer(): Weather {
        return Weather()
    }

    override fun getWeatherFromLocalStorage(): Weather {
        return Weather()
    }
}