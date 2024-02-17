package com.example.solutionx.model

data class AirQualityResponse(
    val dateTime: String,
    val regionCode: String,
    val indexes: List<AirQualityIndex>,
    val pollutants: List<Pollutant>,
    val healthRecommendations: HealthRecommendations
)
