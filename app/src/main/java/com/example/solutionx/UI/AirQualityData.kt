package com.example.solutionx.UI

import com.example.solutionx.APIService.AirQualityClient
import com.example.solutionx.APIService.AirQualityResponse

class AirQualityData {
    // Example usage in AirQualityScreen
    val airQualityResponse = AirQualityClient.airQualityApiService.getCurrentConditions(latitude, longitude)
    suspend fun getCurrentAirQuality(latitude: Double, longitude: Double): AirQualityResponse {
        return AirQualityClient.airQualityApiService.getCurrentConditions(latitude, longitude)
    }
}