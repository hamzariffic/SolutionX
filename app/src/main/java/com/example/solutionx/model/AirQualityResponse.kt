package com.example.solutionx.model

import com.example.solutionx.UI.AirQualityResponse

data class AirQualityResponse(
    val dateTime: String,
    val regionCode: String,
    val indexes: List<Index>,
    val pollutants: List<Pollutant<Any?>>,
    val healthRecommendations: HealthRecommendations
) {
    val isSuccessful: Boolean
        get() = indexes.isNotEmpty()

    fun body() {
        AirQualityResponse()
    }

    private fun errorBody() {
        errorBody()
    }

    fun message() {
        return errorBody()
    }
}
