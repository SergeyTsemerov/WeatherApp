package ru.geekbrains.weatherapp.model.repository

import ru.geekbrains.weatherapp.model.data.Weather
import ru.geekbrains.weatherapp.model.data.convertHistoryEntityToWeather
import ru.geekbrains.weatherapp.model.data.convertWeatherToEntity
import ru.geekbrains.weatherapp.room.HistoryDao

class LocalRepositoryImpl(private val localDataSource: HistoryDao) : LocalRepository {
    override fun getAllHistory(): List<Weather> {
        return convertHistoryEntityToWeather(localDataSource.all())
    }

    override fun saveEntity(weather: Weather) {
        return localDataSource.insert(convertWeatherToEntity(weather))
    }
}