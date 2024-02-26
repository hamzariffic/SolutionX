package com.example.solutionx.model

//Defining the data model for the air quality response with some properties
data class AirQualityResponse(
    val dateTime: String,
    val regionCode: String,
    val indexes: List<Index>,
    val pollutants: List<Pollutant<Any?>>,
    val healthRecommendations: HealthRecommendations
) {
    constructor() : this(
        dateTime = "",
        regionCode = "",
        indexes = emptyList(),
        pollutants = emptyList(),
        healthRecommendations = HealthRecommendations()
    )

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
