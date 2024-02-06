package com.example.solutionx.UI


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController

@Composable
fun AirQualityScreen(viewModel: NavHostController, latitude: Double, longitude: Double) {
    val airQualityResponse by viewModel.airQualityResponse.collectAsState()

    // Check if data is available and display it
    if (airQualityResponse != null) {
        // Display air quality data using the provided UI components
        AirQualityDataComponent(airQualityResponse!!)
    } else {
        // Show loading indicator or error message
    }
}