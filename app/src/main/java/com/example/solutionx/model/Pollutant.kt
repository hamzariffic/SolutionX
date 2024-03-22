package com.example.solutionx.model

data class HistoryResponse(
    val hoursInfo: List<HourInfo>,
    val regionCode: String,
    val nextPageToken: String?
)

data class HourInfo(
    val dateTime: String,
    val indexes: List<AirQualityIndex>,
    val pollutants: List<Pollutant>,
    val healthRecommendations: HealthRecommendations
)

data class AirQualityIndex(
    val category: String,
    val description: String,
    val name: String,
    val localizedName: String,
    val dominantPollutant: String,
    val dominantPollutantDescription: String,
    val level: String,
    val color: String,
    val categoryNumber: Int
)

data class Pollutant(
    val name: String,
    val conc: Double,
    val concUnit: String,
    val aqi: Int,
    val category: String,
    val categoryNumber: Int
)

data class HealthRecommendations(
    val generalPopulation: String,
    val elderly: String,
    val lungDiseasePopulation: String,
    val heartDiseasePopulation: String,
    val athletes: String,
    val pregnantWomen: String,
    val children: String
)
