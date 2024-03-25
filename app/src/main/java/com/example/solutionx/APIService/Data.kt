package com.example.solutionx.APIService

import com.example.solutionx.model.CustomLocalAqi
import com.example.solutionx.model.ExtraComputation
import com.example.solutionx.model.HealthRecommendations
import com.example.solutionx.model.Pollutant
import com.google.android.gms.maps.model.LatLng

//I'm planning on migrating all data related stuff to this class
data class HistoryRequest(
    val hours: Int,
    val pageSize: Int,
    val pageToken: String? = null,
    val location: Location
)

data class HistoricalDataResponse(
    val hoursInfo: List<HourlyInfo>,
    val regionCode: String,
    val nextPageToken: String? = null
)

data class HourlyInfo(
    val dateTime: String,
    val indexes: List<Index>
)

data class Index(
    val code: String,
    val displayName: String,
    val aqi: Int,
    val aqiDisplay: String,
    val color: Color,
    val category: PollutantCategory,
    val dominantPollutant: String
)

data class Color(
    val red: Int,
    val green: Int,
    val blue: Int,
    val alpha: Int? = null
)

data class Location(
    val latitude: Double,
    val longitude: Double
)

data class AirQualityRequest(
    val location: Unit,
    val extraComputations: List<ExtraComputation>,
    val customLocalAqis: List<CustomLocalAqi>,
    val universalAqi: Boolean,
    val languageCode: String
) {
    constructor(location: Unit) : this(
        location = location,
        extraComputations = emptyList(),
        customLocalAqis = emptyList(),
        universalAqi = false,
        languageCode = ""
    )
}

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
}

data class HistoryLookupRequest(
    val pageSize: Int = 0,
    val pageToken: String = "",
    val location: LatLng = LatLng(0.0, 0.0),
    val extraComputations: List<ExtraComputation> = emptyList(),
    val customLocalAqis: List<CustomLocalAqi> = emptyList(),
    val timeRange: TimeRange = TimeRange("", 0, Interval("", "")),
    val universalAqi: Boolean = false,
    val languageCode: String = "",
    val key: String
)

data class HistoryResponse(
    val hoursInfo: List<HourlyInfo>,
    val regionCode: String,
    val nextPageToken: String
)

data class TimeRange(
    val dateTime: String,
    val hours: Int,
    val period: Interval
)

data class Interval(
    val startTime: String,
    val endTime: String
)

enum class PollutantCategory {
    CATEGORY_1,
    CATEGORY_2,
    CATEGORY_3
}