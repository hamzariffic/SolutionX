package com.example.solutionx.model

import androidx.compose.ui.graphics.Color
import com.google.android.gms.maps.model.LatLng

data class HistoryLookupRequest(
    val pageSize: Int = 0,
    val pageToken: String = "",
    val location: LatLng,
    val extraComputations: List<ExtraComputation>,
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
        customLocalAqis = emptyList(),
        timeRange = Unit,
        universalAqi = false,
        languageCode = "en",
        uaqiColor = Color(0xFF00FF00)
    )
}
