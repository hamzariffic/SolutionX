package com.example.solutionx.model

import androidx.compose.ui.graphics.Color
import com.google.android.gms.maps.model.LatLng

data class HistoryLookupRequest(
    val pageSize: Int,
    val pageToken: String,
    val location: LatLng,
    val extraComputations: List<ExtraComputation>,
    val uaqiColorPalette: com.example.solutionx.model.Color?,
    val customLocalAqis: List<CustomLocalAqi>,
    val timeRange: Unit,
    val universalAqi: Boolean,
    val languageCode: String,
    val uaqiColor: Color
) {
    constructor(pageSize: Int, pageToken: String, location: LatLng) : this(
        pageSize = pageSize,
        pageToken = pageToken,
        location = location,
        extraComputations = emptyList(),
        uaqiColorPalette = null,
        customLocalAqis = emptyList(),
        timeRange = Unit,
        universalAqi = false,
        languageCode = "en",
        uaqiColor = Color.White
    )
}
data class Period(
    val startTime: String,
    val endTime: String
)