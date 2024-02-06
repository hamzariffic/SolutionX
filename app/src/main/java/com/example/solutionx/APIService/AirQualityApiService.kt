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
    // Define the structure of the response
)
