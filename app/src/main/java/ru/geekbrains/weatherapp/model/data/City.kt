package ru.geekbrains.weatherapp.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(val city: String, val lat: Double, val lon: Double) : Parcelable
