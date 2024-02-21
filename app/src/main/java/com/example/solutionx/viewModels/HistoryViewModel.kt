package com.example.solutionx.viewModels

import androidx.lifecycle.ViewModel
import com.example.solutionx.APIService.AirQualityApiService
import com.example.solutionx.APIService.AirQualityClient.airQualityHistoryApiService
import com.example.solutionx.APIService.HourlyInfo
import com.example.solutionx.model.HistoryLookupRequest

class HistoryViewModel : ViewModel() {
    private val airQualityApiService = AirQualityApiService.create()
    suspend fun fetchAirQualityHistory(historyRequest: HistoryLookupRequest): List<HourlyInfo> {
        return airQualityHistoryApiService.getAirQualityHistory(historyRequest)
    }

}