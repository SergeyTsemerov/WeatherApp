package ru.geekbrains.weatherapp.model.repository

import retrofit2.Callback
import ru.geekbrains.weatherapp.model.dto.WeatherDTO

interface DetailsRepository {

    fun getWeatherDetailsFromServer(lat: Double, lon: Double, callback: Callback<WeatherDTO>)
}