package com.example.solutionx.model

import androidx.lifecycle.ViewModel
import com.example.solutionx.APIService.AirQualityApiService
import com.example.solutionx.APIService.HistoryRequest
import com.example.solutionx.APIService.HourlyInfo

class HistoryViewModel : ViewModel() {
    private val airQualityApiService = AirQualityApiService.create()
    suspend fun fetchAirQualityHistory(historyRequest: HistoryRequest): List<HourlyInfo> {
        return airQualityApiService.getHourlyAirQualityHistory(historyRequest)
    }

}
