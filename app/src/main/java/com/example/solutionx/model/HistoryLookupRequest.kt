package com.example.solutionx.model

import com.google.type.LatLng

data class HistoryLookupRequest(
    val pageSize: Int,
    val pageToken: String,
    val location: LatLng,
    val extraComputations: List<ExtraComputation>,
    val uaqiColorPalette: ColorPalette,
    val customLocalAqis: List<CustomLocalAqi>,
    val timeRange: TimeRange,
    val universalAqi: Boolean,
    val languageCode: String
)
