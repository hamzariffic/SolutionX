package com.example.solutionx.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.solutionx.model.AirQualityRequest
import com.example.solutionx.model.AirQualityResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.solutionx.APIService.AirQualityApiService
import com.example.solutionx.model.HealthRecommendations
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.auth.http.HttpCredentialsAdapter
import com.google.auth.oauth2.GoogleCredentials

@Suppress("DEPRECATION")
class AirQualityViewModel(private val apiService: AirQualityApiService) : ViewModel() {
    private val _airQualityData by lazy { MutableLiveData<AirQualityResponse>() }
    val airQualityData: LiveData<AirQualityResponse> = _airQualityData

    private var airQualityRequest: AirQualityRequest? = null

    suspend fun fetchAirQualityData() {
        airQualityRequest?.let { request ->
            apiService.currentConditions(request)
                .enqueue(object : Callback<AirQualityResponse> {
                    override fun onResponse(
                        call: Call<AirQualityResponse>,
                        response: Response<AirQualityResponse>
                    ) {
                        if (response.isSuccessful) {
                            _airQualityData.value = response.body()
                        } else {
                            println("Could not get Air Quality Conditions")
                        }
                    }

                    override fun onFailure(call: Call<AirQualityResponse>, t: Throwable) {
                        println("Network request failed: ${t.message}")
                    }
                })
        }
    }
    fun fetchAirQualityData(viewModel: AirQualityRequest): AirQualityResponse {
        // Obtain credentials from environment or secure storage
        val credentials = GoogleCredentials.getApplicationDefault()

        // Use the built-in service builder from the library
        val service = Aqi.Builder(NetHttpTransport(), JacksonFactory(), HttpCredentialsAdapter(credentials))
            .setApplicationName("SolutionX")
            .build()

        // Make the API request using the library's methods
        val response = service.projects().locations().currentConditions()
            .get("solutionx-413420", "ChIJ5xhxvFMQLxgRdYHS8XZTNgs")
            .execute()

        // Parse the response into your data model (modify with appropriate fields)
        val airQualityResponse = AirQualityResponse(
            dateTime = response.updateTime,
            regionCode = response.placeId,
            indexes = response.aqi,
            pollutants = response.dominantPollutant,
            healthRecommendations = response.healthRecommendations
        )
        // Parse the response into the data class
        return AirQualityResponse(dateTime = "", regionCode = "", indexes = emptyList(), pollutants = emptyList(), healthRecommendations = HealthRecommendations())
    }
}
