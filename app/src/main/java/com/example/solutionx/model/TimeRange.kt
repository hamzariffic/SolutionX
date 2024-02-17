package com.example.solutionx.model

import com.example.solutionx.APIService.Interval


data class TimeRange(
    val dateTime: String,
    val hours: Int,
    val period: Interval
)
