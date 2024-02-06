package com.example.solutionx.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solutionx.APIService.AirQualityClient
import com.example.solutionx.APIService.AirQualityResponse
import kotlinx.coroutines.launch


//This view model fetches the air quality data and exposes it to the UI
class AirQualityViewModel : ViewModel() {
    private val airQualityClient = AirQualityClient.airQualityApiService

    private val _airQualityResponse = mutableStateOf<AirQualityResponse?>(null)
    val airQualityResponse = _airQualityResponse

    fun fetchAirQuality(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            try {
                _airQualityResponse.value = airQualityClient.getCurrentConditions(latitude, longitude)
            } catch (e: Exception) {
                // Handle error
                print("Could not get data")
            }
        }
    }
}
