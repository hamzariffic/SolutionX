package com.example.solutionx.viewModels

import androidx.lifecycle.ViewModel
import com.example.solutionx.APIService.AirQualityClient.airQualityHistoryApiService
import com.example.solutionx.APIService.HourlyInfo

class HistoryViewModel : ViewModel() {
    suspend fun fetchAirQualityHistory(historyRequest: Unit): List<HourlyInfo> {
        return airQualityHistoryApiService.getAirQualityHistory(historyRequest)
    }

}
