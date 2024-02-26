package com.example.solutionx.model

import com.google.type.LatLng

data class AirQualityRequest(
    val location: LatLng,
    val extraComputations: List<ExtraComputation>,
    val customLocalAqis: List<CustomLocalAqi>,
    val universalAqi: Boolean,
    val languageCode: String
) {
    constructor(regionCode: Any) : this(
        location = regionCode as LatLng,
        extraComputations = emptyList(),
        customLocalAqis = emptyList(),
        universalAqi = false,
        languageCode = "en"
    )

}
