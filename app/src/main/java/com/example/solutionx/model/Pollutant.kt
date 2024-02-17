package com.example.solutionx.model

data class Pollutant(
    val code: String,
    val displayName: String,
    val fullName: String,
    val concentration: Concentration,
    val additionalInfo: PollutantAdditionalInfo
)
