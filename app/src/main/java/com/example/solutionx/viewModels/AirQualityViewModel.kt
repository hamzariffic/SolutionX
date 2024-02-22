package com.example.solutionx.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.solutionx.APIService.AirQualityApiService
import com.example.solutionx.model.AirQualityRequest
import com.example.solutionx.model.AirQualityResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AirQualityViewModel(private val apiService: AirQualityApiService) : ViewModel() {
    private val _airQualityData by lazy { MutableLiveData<AirQualityResponse>() }
    val airQualityData: LiveData<AirQualityResponse> = _airQualityData

    var airQualityRequest: AirQualityRequest? = null

    suspend fun fetchAirQualityData() {
        airQualityRequest?.let { request ->
            apiService.currentConditions(request)
                .enqueue(object : Callback<AirQualityResponse> {
                    override fun onResponse(
                        call: Call<AirQualityResponse>,
                        response: Response<AirQualityResponse>,
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
}
