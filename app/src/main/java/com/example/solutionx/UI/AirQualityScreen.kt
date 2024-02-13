package com.example.solutionx.UI


import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.solutionx.ViewModel.AirQualityViewModel


//Fix this bug "    val airQualityResponse by viewModel.airQualityResponse.collectAsState()"
//& also the bug when checking if data is available
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

    Card() {
//        Current conditions
        ElevatedButton(onClick = { navController.navigate("home") }) {
            Text(text = "Back")
        }
    }
    Card() {
//        Hourly history
    }
    Card(){
//        Heatmaps
    }
}

//
//Current Conditions: Real-time hourly air quality information.
//Hourly History: Air quality history for a specific location, for a given time range, up to a maximum of 30 days.
//Heatmaps: Color coded tiles of various indexes and pollutants.
