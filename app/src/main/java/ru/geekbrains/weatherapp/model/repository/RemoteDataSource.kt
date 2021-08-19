package ru.geekbrains.weatherapp.model.repository

import com.google.gson.GsonBuilder
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.geekbrains.weatherapp.BuildConfig
import ru.geekbrains.weatherapp.model.dto.WeatherDTO

class RemoteDataSource {

    private val weatherAPI = Retrofit.Builder()
        .baseUrl("https://api.weather.yandex.ru/")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().setLenient().create()
            )
        ).build().create(WeatherAPI::class.java)

    fun getWeatherDetails(lat: Double, lon: Double, callback: Callback<WeatherDTO>) {
        weatherAPI.getWeather(BuildConfig.WEATHER_API_KEY, lat, lon).enqueue(callback)
    }
}