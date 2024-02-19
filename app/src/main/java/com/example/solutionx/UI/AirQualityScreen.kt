package com.example.solutionx.UI

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.solutionx.model.AirQualityResponse
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.aqi.v1.AqiScopes
import com.google.auth.http.HttpCredentialsAdapter
import com.google.auth.oauth2.GoogleCredentials
import java.util.Collections

// Define the UI component
@Composable
fun AirQualityDataComponent(airQualityResponse: AirQualityResponse) {
    Text(text = airQualityResponse.toString())
}

// Define the main function
fun main(args: Array<String>) {
    // Initialize the HTTP transport and JSON factory
    val httpTransport = NetHttpTransport()
    val jsonFactory = JacksonFactory()

    // Get the credentials from the environment
    val credentials = GoogleCredentials.getApplicationDefault()
        .createScoped(Collections.singleton(AqiScopes.AQI_CURRENT_CONDITIONS))

    // Create the HttpRequestInitializer
    val requestInitializer = object : HttpRequestInitializer {
        override fun initialize(request: com.google.api.client.http.HttpRequest) {
            val credentialAdapter = HttpCredentialsAdapter(credentials)
            request.setInterceptor(credentialAdapter)
        }
    }

    // Build the API client
    val service = com.google.api.services.aqi.v1.Aqi.Builder(httpTransport, jsonFactory, requestInitializer)
        .setApplicationName("AQI API Kotlin Sample")
        .build()

    // Make the API request
    val response = service.projects().locations().currentConditions()
        .get("your-project-id", "your-location-id")
        .execute().also {

            // Print the response
            val it = null
            println(it)
        }
}

@Preview
@Composable
fun AirQualityData() {

}
