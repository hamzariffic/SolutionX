package com.example.solutionx.UI

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.solutionx.model.HealthRecommendations
import com.example.solutionx.viewModels.AirQualityViewModel

@Composable
fun HealthRecommendationsScreen(
    navController: NavController,
    healthRecommendations: HealthRecommendations
) {
    // Fetch the air quality data
    val regionCode = null
    val request = regionCode?.let { AirQualityRequest(it) }
    val airQualityResponse by AirQualityViewModel.airQualityData.observeAsState()

    AirQualityViewModel.fetchAirQualityData(request!!)
    // Display the health recommendations
    Column {
        Text("Health Recommendations")
        Text("General Population: ${healthRecommendations.generalPopulation}")
        Text("Elderly: ${healthRecommendations.elderly}")
        Text("Lung Disease Population: ${healthRecommendations.lungDiseasePopulation}")
        Text("Heart Disease Population: ${healthRecommendations.heartDiseasePopulation}")
        Text("Athletes: ${healthRecommendations.athletes}")
        Text("Pregnant Women: ${healthRecommendations.pregnantWomen}")
        Text("Children: ${healthRecommendations.children}")

        // Button to navigate back to the currentConditions screen
        Button(onClick = { navController.popBackStack() }) {
            Text("Back to Current Conditions")
        }
    }
}
