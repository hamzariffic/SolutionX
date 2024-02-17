package com.example.solutionx.model

import com.example.solutionx.APIService.Color
data class Index(
    val code: String,
    val displayName: String,
    val aqi: Int,
    val aqiDisplay: String,
    val color: Color,
    val category: String,
    val dominantPollutant: String
)
