package com.example.solutionx.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solutionx.APIService.AirQualityApiService
import kotlinx.coroutines.launch

class AirQualityViewModel(private val apiService: AirQualityApiService) : ViewModel() {
    private val _airQualityData = MutableLiveData<AirQualityResponse>()
    val airQualityData: LiveData<AirQualityResponse> get() = _airQualityData

    fun fetchAirQualityData(airQualityRequest: AirQualityRequest) {
        viewModelScope.launch {
            try {
                val call = apiService.getCurrentConditions(airQualityRequest)
                val response = call.awaitResponse()

                if (response.isSuccessful) {
                    _airQualityData.value = response.body()
                } else {
                    println("Could not get Air Quality Conditions")
                }
            } catch (e: Exception) {
                println("Could not get Air Quality Conditions")}
        }
    }
}
