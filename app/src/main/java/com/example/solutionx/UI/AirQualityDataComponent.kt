package com.example.solutionx.UI

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.solutionx.model.AirQualityResponse
import com.example.solutionx.model.AirQualityViewModel
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import java.util.Collections

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
    val response = service.projects().locations().currentConditions().get("your-project-id", "your-location-id")
        .execute()

    // Print the response
    println(response)
}

// Define the UI component
@JvmOverloads
@Composable
fun AirQualityDataComponent(viewModel: AirQualityViewModel = viewModel) {
    Text(text = AirQualityResponse.toString())
}

