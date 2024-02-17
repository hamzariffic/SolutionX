package com.example.solutionx.model


data class TimeRange(
    val dateTime: String,
    val hours: Int,
    val period: Interval
)
data class Interval(
    val startTime: String,
    val endTime: String
)