package ru.geekbrains.weatherapp.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather(
    val city: City = getDefaultCity(),
    val temperature: Int = 0,
    val feelsLike: Int = 0,
    val condition: String = "rain"
) : Parcelable

fun getDefaultCity() = City("Moscow", 55.755826, 37.617299)
