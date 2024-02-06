package com.example.solutionx.APIService

import retrofit2.http.GET
import retrofit2.http.Query

interface AirQualityApiService {

//    The current endpoint defines the location of the individual to provide the air quality data
    @GET("currentConditions:lookup?")
    suspend fun getCurrentConditions(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        // Add other necessary parameters
    ): AirQualityResponse
}

data class AirQualityResponse(
    val hoursInfo: List<HourlyInfo>,
    val regionCode: String,
    val nextPageToken: String?,
    val code: String,
    val displayName: String,
    val aqi: Int,
    val aqiDisplay: String,
    val color: Color,
    val category: String,
    val dominantPollutant: String
)
