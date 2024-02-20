package com.example.solutionx.model

import com.example.solutionx.APIService.ColorPalette

data class HistoryLookupRequest(
    val pageSize: Int,
    val pageToken: String,
    val location: com.google.android.gms.maps.model.LatLng,
    val extraComputations: List<ExtraComputation>,
    val uaqiColorPalette: ColorPalette,
    val customLocalAqis: List<CustomLocalAqi>,
    val timeRange: TimeRange,
    val universalAqi: Boolean,
    val languageCode: String
)
