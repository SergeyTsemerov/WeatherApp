package ru.geekbrains.weatherapp.model.repository

import retrofit2.Callback
import ru.geekbrains.weatherapp.model.dto.WeatherDTO

class DetailsRepositoryImpl(private val remoteDataSource: RemoteDataSource) : DetailsRepository {
    override fun getWeatherDetailsFromServer(
        lat: Double,
        lon: Double,
        callback: Callback<WeatherDTO>
    ) {
        remoteDataSource.getWeatherDetails(lat, lon, callback)
    }
}