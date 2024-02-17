package com.example.solutionx.model
data class HistoryRequest(
    val hours: Int,
    val pageSize: Int,
    val pageToken: String?,
    val location: Location
)
