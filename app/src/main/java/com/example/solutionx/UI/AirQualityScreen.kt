package com.example.solutionx.ui

import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.solutionx.UI.AirQualityDataComponent
import com.example.solutionx.UI.HeatmapDataComponent
import com.example.solutionx.UI.HourlyHistoryDataComponent
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
        println("Nothing here!")
    }
    Card() {
        // Current conditions
        ElevatedButton(onClick = { navController.navigate("home") }) {
            Text(text = "Back")
        }
    }
    Card() {
        // Hourly history
        ElevatedButton(onClick = {
            // Get the hourly history data from the API
            val hourlyHistoryResponse = viewModel.getHourlyHistory(latitude, longitude)

            // Display the hourly history data using the provided UI components
            HourlyHistoryDataComponent(hourlyHistoryResponse!!)
        }) {
            Text(text = "Hourly History")
        }
    }
    Card(){
        // Heatmaps
        ElevatedButton(onClick = {
            // Get the heatmap data from the API
            val heatmapResponse = viewModel.getHeatmap(latitude, longitude)

            // Display the heatmap data using the provided UI components
            HeatmapDataComponent<Any>(heatmapResponse!!)
        }) {
            Text(text = "Heatmaps")
        }
    }
}
