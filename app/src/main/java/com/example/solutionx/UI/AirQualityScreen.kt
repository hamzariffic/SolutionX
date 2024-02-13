package com.example.solutionx.UI


import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.solutionx.APIService.HourlyInfo
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
        println("Nothing here!")
    }
    Card() {
//        Current conditions
        ElevatedButton(onClick = { navController.navigate("home") }) {
            Text(text = "Back")
        }
    }
    Card() {
//        Hourly history
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
//        Heatmaps
        ElevatedButton(onClick = {
            // Get the heatmap data from the API
            val heatmapResponse = viewModel.getHeatmap(latitude, longitude)

            // Display the heatmap data using the provided UI components
            HeatmapDataComponent(heatmapResponse!!)
        }) {
            Text(text = "Heatmaps")
        }
    }
}

@Composable
fun HourlyHistoryDataComponent(hourlyHistoryResponse: HourlyInfo) {

}


@Composable
fun HeatmapDataComponent(heatmapResponse: heatMapResponse) {
    Text(text = heatmapResponse.toString())
}

@Composable
fun AirQualityDataComponent(airQualityResponse: airQualityResponse) {
    Text(text = airQualityResponse.toString())
}

//Current Conditions: Real-time hourly air quality information.
//Hourly History: Air quality history for a specific location, for a given time range, up to a maximum of 30 days.
//Heatmaps: Color coded tiles of various indexes and pollutants.


@Preview(showBackground = true)
@Composable
fun AirQualityScreenPreview() {
    val navController = rememberNavController()
    AirQualityScreen(navController, 39.6682, 4.04354)
}