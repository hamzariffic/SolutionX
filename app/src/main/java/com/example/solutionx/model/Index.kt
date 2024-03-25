package com.example.solutionx.model

data class HistoryResponse(
    val hoursInfo: List<HourInfo>,
    val regionCode: String,
    val nextPageToken: String?
)

data class HourInfo(
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
    val alpha: Int
)