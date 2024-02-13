package com.example.solutionx.UI

import com.example.solutionx.APIService.AirQualityClient
import com.example.solutionx.APIService.AirQualityResponse

//This is the screen where users will be viewing their air quality data based on the locations they dynamically choose
//More implementations need to be done especially on longitude and latitude bugs I parsed inside the CurrentConditions endpoint
class AirQualityData(var airQualityResponse: String, var airQualityIndex: Int) {

    // Example usage in AirQualityScreen
    val airQualityResponse = AirQualityClient.airQualityApiService.CurrentConditions(latitude, longitude)
    suspend fun getCurrentAirQuality(latitude: Double, longitude: Double): AirQualityResponse {
        return AirQualityClient.airQualityApiService.getCurrentConditions(latitude, longitude)
    }
}