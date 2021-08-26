package ru.geekbrains.weatherapp.room

import androidx.room.*

const val ID = "id"
const val CITY = "city"
const val TEMPERATURE = "temperature"

@Entity
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val city: String = "",
    val temperature: Int = 0,
    val condition: String = ""
)
