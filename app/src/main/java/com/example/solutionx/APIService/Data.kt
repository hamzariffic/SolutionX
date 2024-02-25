package com.example.solutionx.APIService

import com.example.solutionx.model.CustomLocalAqi
import com.example.solutionx.model.ExtraComputation
import com.example.solutionx.model.HealthRecommendations
import com.example.solutionx.model.Pollutant
import com.google.type.LatLng

//I'm planning on migrating all data related stuff to this class
data class HistoryRequest(
    val hours: Int,
    val pageSize: Int,
    val pageToken: String?,
    val location: Location
)

data class HistoricalDataResponse(
    val hoursInfo: List<HourlyInfo>,
    val regionCode: String,
    val nextPageToken: String?
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
    val category: String,
    val dominantPollutant: String
)

data class Color(
    val red: Int,
    val green: Int,
    val blue: Int,
    val alpha: Int?
)

data class Location(
    val latitude: Double,
    val longitude: Double
)

data class AirQualityRequest(
    val location: LatLng,
    val extraComputations: List<ExtraComputation>,
    val customLocalAqis: List<CustomLocalAqi>,
    val universalAqi: Boolean,
    val languageCode: String
)

data class AirQualityResponse(
    val dateTime: String,
    val regionCode: String,
    val indexes: List<Index>,
    val pollutants: List<Pollutant<Any?>>,
    val healthRecommendations: HealthRecommendations
)


//This is a data class for history. Should be moved elsewhere
data class HistoryLookupRequest(
    val pageSize: Int,
    val pageToken: String,
    val location: LatLng,
    val extraComputations: List<ExtraComputation>,
    val customLocalAqis: List<CustomLocalAqi>,
    val timeRange: TimeRange,
    val universalAqi: Boolean,
    val languageCode: String
) { constructor() : this(
        pageSize = 0,
        pageToken = "",
        location = com.google.android.gms.maps.model.LatLng(0.0, 0.0),
        extraComputations = emptyList(),
        customLocalAqis = emptyList(),
        timeRange = TimeRange("", 0, Interval("", "")),
        universalAqi = false,
        languageCode = ""
    )
}

data class HistoryLookupResponse(
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