package com.example.solutionx.model

import com.google.type.LatLng

data class AirQualityRequest(
    val location: LatLng,
    val extraComputations: List<ExtraComputation>,
    val customLocalAqis: List<CustomLocalAqi>,
    val universalAqi: Boolean,
    val languageCode: String
) {

    fun body() {
        AirQualityRequest(location, extraComputations, customLocalAqis, universalAqi, languageCode)
    }
}
