package com.example.solutionx.model

import android.os.Parcel

data class HistoryResponse(
    val hoursInfo: List<HourlyInfo>,
    val regionCode: String,
    val nextPageToken: String?,
    val dateTime: String,
    val indexes: ArrayList<Index>?,
    val code: Parcel?,
    val displayName: String?,
    val aqi: Int,
    val aqiDisplay: String?,
    val color: Color?,
    val category: String?,
    val dominantPollutant: String?
)

{
    val data: Any
        get() = hoursInfo}

