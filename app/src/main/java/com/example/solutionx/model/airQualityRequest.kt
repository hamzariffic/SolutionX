package com.example.solutionx.model

import com.example.solutionx.APIService.ColorPalette
import com.google.type.LatLng

data class AirQualityRequest(
    val location: LatLng,
    val extraComputations: List<ExtraComputation>,
    val uaqiColorPalette: ColorPalette,
    val customLocalAqis: List<CustomLocalAqi>,
    val universalAqi: Boolean,
    val languageCode: String
)
