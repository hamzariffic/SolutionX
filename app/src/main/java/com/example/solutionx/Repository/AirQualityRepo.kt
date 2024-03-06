package com.example.solutionx.Repository

import com.example.solutionx.APIService.AirQualityApiService
import com.example.solutionx.APIService.AirQualityRequest
import com.example.solutionx.Repository.Result.Error
import com.example.solutionx.model.AirQualityResponse


//This class will handle he API calls and data fetching logic. We will use it to fetch air quality data
//"Result" or "Either approach"
class AirQualityRepository(private val apiService: AirQualityApiService) {

    suspend fun fetchAirQualityData(request: AirQualityRequest): Result<AirQualityResponse> {
        return try {
             val response = apiService.currentConditions(request)
            if (response.isSuccessful) {
                response.body()?.let { Result.Success(it) } ?: Error("Empty response body")
            } else Error("Could not get Air Quality Conditions: ${response.message()}")
        } catch (e: Exception) {
            Error("Network request failed: ${e.message}")
        }
    }
}

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
}