package com.example.solutionx.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.solutionx.APIService.AirQualityApiService
import com.example.solutionx.model.AirQualityRequest
import com.example.solutionx.model.AirQualityResponse

@Suppress("NAME_SHADOWING")
class AirQualityViewModel(private val apiService: AirQualityApiService, private val locationViewModel: LocationViewModel
) : ViewModel() {


    val hourlyHistoryData: Any?
        get() = null

    private val _airQualityData by lazy { MutableLiveData<AirQualityResponse>() }
    val airQualityData: LiveData<AirQualityResponse> = _airQualityData

    private val _errorLiveData by lazy { MutableLiveData<String>() }

    private var airQualityRequest: AirQualityRequest? = null

    suspend fun fetchAirQualityData(request: Unit) {
        val currentLocation = locationViewModel.getCurrentLocation()


        currentLocation?.let { location ->
            val request = AirQualityRequest(location = location)
        airQualityRequest?.let { request ->
            try {
                val response = apiService.currentConditions(request)
                if (response.isSuccessful) {
                    response.body().also { _airQualityData.value = it }
                } else {
                    _errorLiveData.value = "Could not get Air Quality Conditions: ${response.message()}"
                    _airQualityData.value = null // Clear previous data on error
                }
            } catch (e: Exception) {
                _errorLiveData.value = "Network request failed: ${e.message}"
                _airQualityData.value = null // Clear previous data on error
            }
        }
    }

    companion object {
        private val _airQualityData by lazy { MutableLiveData<AirQualityResponse>() }
        fun fetchAirQualityData(request: Unit) {
        }
    }
}
