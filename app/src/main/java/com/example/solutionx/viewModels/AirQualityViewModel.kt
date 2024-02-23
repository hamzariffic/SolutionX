package com.example.solutionx.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.solutionx.APIService.AirQualityApiService
import com.example.solutionx.model.AirQualityRequest
import com.example.solutionx.model.AirQualityResponse

class AirQualityViewModel(private val apiService: AirQualityApiService) : ViewModel() {
    private val _airQualityData by lazy { MutableLiveData<AirQualityResponse>() }
    val airQualityData: LiveData<AirQualityResponse> = _airQualityData

    private var airQualityRequest: AirQualityRequest? = null

    suspend fun fetchAirQualityData(unit: Unit) {
        airQualityRequest?.let { request ->
            try {
                val response = apiService.currentConditions(request)
                if (response.isSuccessful) {
                    response.body()?.also { it -> _airQualityData.value = it }
                } else {
                    println("Could not get Air Quality Conditions: ${response.message()}")
                }
            } catch (e: Exception) {
                println("Network request failed: ${e.message}")
            }
        }
    }
}
