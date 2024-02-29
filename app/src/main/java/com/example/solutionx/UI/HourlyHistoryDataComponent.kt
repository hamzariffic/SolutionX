package com.example.solutionx.UI

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.solutionx.model.HourlyInfo

@Composable
fun HourlyHistoryDataComponent(HourlyInfo: List<HourlyInfo>) {
    // Display the list of HourlyInfo data in an area
    for (hourlyInfo in HourlyInfo) {
        Text(text = hourlyInfo.toString())
    }
}

//commented out color for this time since I have a bug to fix

@Preview
@Composable
fun PreviewHourlyHistoryDataComponent() {
    // Passing a sample HourlyInfo data for preview
    val sampleHourlyInfo = listOf(
        com.example.solutionx.model.HourlyInfo(
            "2024-02-24T15:00:00Z", listOf(
                com.example.solutionx.model.Index(
                    "uaqi",
                    "Universal AQI",
                    73,
                    "73",
//                    Color(118, 202, 51, 255),
                    "Good air quality",
                    "pm10"
                )
            )
        )
    )
    HourlyHistoryDataComponent(sampleHourlyInfo)
}