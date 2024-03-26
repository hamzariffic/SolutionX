package com.example.solutionx.model

import android.os.Parcel
import android.os.Parcelable

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
    val code: Parcel,
    val displayName: String,
    val aqi: Int,
    val aqiDisplay: String,
    val color: Color,
    val category: String,
    val dominantPollutant: String
) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }
}

data class Color(
    val red: Int,
    val green: Int,
    val blue: Int,
    val alpha: Int
)