package com.example.solutionx.UI


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.solutionx.ViewModel.AirQualityViewModel

@Composable
fun AirQualityScreen(navController: NavHostController, latitude: Double, longitude: Double) {
    val viewModel: AirQualityViewModel = viewModel()
    val airQualityResponse by viewModel.airQualityResponse.collectAsState()

    // Check if data is available and display it
    if (airQualityResponse != null) {
        // Display air quality data using the provided UI components
        AirQualityDataComponent(airQualityResponse!!)
    } else {
        // Show loading indicator or error message
    }
}
