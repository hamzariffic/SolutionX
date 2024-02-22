@file:Suppress("DEPRECATION")

package com.example.solutionx.UI

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.example.solutionx.model.AirQualityResponse
import com.example.solutionx.model.HealthRecommendations
import com.example.solutionx.viewModels.AirQualityViewModel
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.auth.oauth2.GoogleCredentials
import com.google.api.client.json.jackson2.JacksonFactory

@Composable
fun AirQualityDataComponent(viewModel: AirQualityViewModel = AirQualityViewModel()) {
    val airQualityResponse by viewModel.airQualityData.observeAsState()
    Text(text = airQualityResponse.toString())

    // Initiate fetching air quality data when the component is first composed
    LaunchedEffect(Unit) {
        viewModel.fetchAirQualityData()
    }
    // Display the air quality data
    Text(text = airQualityResponse.toString())
}

private fun fetchAirQualityData(): AirQualityResponse {
    // Initialize the HTTP transport and JSON factory
    val httpTransport = NetHttpTransport()
    val jsonFactory = JacksonFactory()

    // Get the credentials from the environment
    val credentials = GoogleCredentials.getApplicationDefault()

    // Create the HttpRequestInitializer
    val requestInitializer = HttpRequestInitializer { request ->
        val credentialAdapter = HttpCredentialsAdapter(credentials)
        request.setInterceptor(credentialAdapter)
    }

    // Build the API client
    val service = Aqi.Builder(httpTransport, jsonFactory, requestInitializer)
        .setApplicationName("SolutionX")
        .build()

    // Make the API request
    val apiKey = "AIzaSyAiDHeFyGtYPO8Rz5ZvR__fp1TEfAQRKck"

    val response = service.projects().locations().currentConditions().get("solutionx-413420", "ChIJ5xhxvFMQLxgRdYHS8XZTNgs")
        .setKey(apiKey) // Include API key if required
        .execute()

    // Parse the response into the data class
    return AirQualityResponse(dateTime = "", regionCode = "", indexes = emptyList(), pollutants = emptyList(), healthRecommendations = HealthRecommendations())
}

@Composable
fun AirQualityDataComponentt(viewModel: AirQualityViewModel = viewModel) {
    val airQualityResponse by viewModel.airQualityData.observeAsState()

    LaunchedEffect(Unit) {
        // Fetch air quality data when the component is first composed
        val airQualityRequest = null
        viewModel.run { aalityRequest?.let { fetchAirQualityData(it: AirQualityRequest) } }
    }

    // Display the air quality data
    airQualityResponse?.let { response ->
        Text(text = response.toString())
    }
}

