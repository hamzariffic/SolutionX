package com.example.solutionx.UI

import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.solutionx.APIService.HourlyInfo

@Composable
fun AirQualityDataComponent(airQualityResponse: airQualityResponse) {
    Text(text = airQualityResponse.toString())
}
