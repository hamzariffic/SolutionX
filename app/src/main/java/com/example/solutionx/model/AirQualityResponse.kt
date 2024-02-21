package com.example.solutionx.model

import retrofit2.Callback

data class AirQualityResponse(
    val dateTime: String,
    val regionCode: String,
    val indexes: List<Index>,
    val pollutants: List<Pollutant<Any?>>,
    val healthRecommendations: HealthRecommendations
) {
    fun enqueue(callback: Callback<AirQualityResponse>) {
        TODO("Not yet implemented")
    }
}
