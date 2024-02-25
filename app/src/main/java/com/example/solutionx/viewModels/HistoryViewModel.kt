package com.example.solutionx.viewModels

import androidx.lifecycle.ViewModel
import com.example.solutionx.APIService.AirQualityClient.airQualityHistoryApiService
import com.example.solutionx.APIService.HistoryLookupRequest

class HistoryViewModel : ViewModel() {
    suspend fun fetchAirQualityHistory(historyRequest: Unit): List<HistoryLookupRequest> {
        return airQualityHistoryApiService.getAirQualityHistory(historyRequest)
    }

}
