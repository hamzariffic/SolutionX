package com.example.solutionx.model
data class HistoricalDataResponse(
    val hoursInfo: List<HourlyInfo>,
    val regionCode: String,
    val nextPageToken: String?
)
