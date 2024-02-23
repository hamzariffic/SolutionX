package com.example.solutionx.model

import androidx.compose.ui.graphics.Color

//Contains air quality indices
data class Index(
    val code: String?,
    val displayName: String?,
    val aqi: Int,
    val aqiDisplay: String?,
    val color: Color,
    val category: String,
    val dominantPollutant: String
)
