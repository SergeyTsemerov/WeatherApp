package ru.geekbrains.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.geekbrains.weatherapp.model.AppState
import ru.geekbrains.weatherapp.model.data.convertDtoToModel
import ru.geekbrains.weatherapp.model.dto.FactDTO
import ru.geekbrains.weatherapp.model.dto.WeatherDTO
import ru.geekbrains.weatherapp.model.repository.DetailsRepository
import ru.geekbrains.weatherapp.model.repository.DetailsRepositoryImpl
import ru.geekbrains.weatherapp.model.repository.RemoteDataSource

private const val SERVER_ERROR = "Ошибка сервера"
private const val REQUEST_ERROR = "Ошибка запроса на сервер"
private const val CORRUPTED_DATA = "Неполные данные"

class DetailsViewModel(
    val detailsLiveData: MutableLiveData<AppState> = MutableLiveData(),
    private val detailsRepository: DetailsRepository = DetailsRepositoryImpl(RemoteDataSource())
) : ViewModel() {

    fun getWeatherFromRemoteSource(lat: Double, lon: Double) {
        detailsLiveData.value = AppState.Loading
        detailsRepository.getWeatherDetailsFromServer(lat, lon, callback)
    }

    private val callback = object : Callback<WeatherDTO> {

        override fun onResponse(call: Call<WeatherDTO>, response: Response<WeatherDTO>) {
            val serverResponse: WeatherDTO? = response.body()
            detailsLiveData.postValue(
                if (response.isSuccessful && serverResponse != null) {
                    checkResponse(serverResponse)
                } else {
                    AppState.Error(Throwable(SERVER_ERROR))
                }
            )
        }

        override fun onFailure(call: Call<WeatherDTO>, t: Throwable) {
            detailsLiveData.postValue(AppState.Error(Throwable(t.message ?: REQUEST_ERROR)))
        }
    }

    fun checkResponse(serverResponse: WeatherDTO): AppState {
        val fact: FactDTO? = serverResponse.fact
        return if (fact?.temp == null || fact.feels_like == null || fact.condition.isNullOrEmpty()) {
            AppState.Error(Throwable(CORRUPTED_DATA))
        } else {
            AppState.Success(convertDtoToModel(serverResponse))
        }
    }
}