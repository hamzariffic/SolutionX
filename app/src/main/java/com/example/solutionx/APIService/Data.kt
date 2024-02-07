package com.example.solutionx.APIService

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