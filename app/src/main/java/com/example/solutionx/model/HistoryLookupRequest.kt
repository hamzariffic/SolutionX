package com.example.solutionx.model

import android.graphics.Color
import com.google.android.gms.maps.model.LatLng

data class HistoryLookupRequest(
    val pageSize: Int,
    val pageToken: String,
    val location: LatLng,
    val extraComputations: List<ExtraComputation>,
    val customLocalAqis: List<CustomLocalAqi>,
    val timeRange: Unit,
    val universalAqi: Boolean,
    val languageCode: String,
    val uaqiColor: Color
)
