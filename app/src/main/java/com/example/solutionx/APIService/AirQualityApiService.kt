package com.example.solutionx.APIService

import com.example.solutionx.model.AirQualityRequest
import com.example.solutionx.model.AirQualityResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AirQualityApiService {
//    The current endpoint defines the location of the individual to provide the air quality data
    @POST("currentConditions:lookup?")
    suspend fun getCurrentConditions(
        @Body airQualityRequest: AirQualityRequest
        ): AirQualityResponse
}