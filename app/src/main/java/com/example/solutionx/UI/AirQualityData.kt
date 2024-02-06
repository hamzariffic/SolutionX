package com.example.solutionx.UI

class AirQualityData {
    // Example usage in AirQualityScreen
    val airQualityResponse = viewModel.getCurrentConditions(latitude, longitude)
    suspend fun getCurrentAirQuality(latitude: Double, longitude: Double): AirQualityResponse {
        return AirQualityClient.airQualityApiService.getCurrentConditions(latitude, longitude)
    }
}