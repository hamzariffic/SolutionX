package com.example.solutionx.viewModels

import androidx.lifecycle.ViewModel
import com.example.solutionx.APIService.AirQualityClient.airQualityHistoryApiService
import com.example.solutionx.APIService.History

class HistoryViewModel : ViewModel() {
    fun fetchAirQualityHistory(historyRequest: com.example.solutionx.model.HistoryLookupRequest) {
        return airQualityHistoryApiService.getAirQualityHistory(History)
    }
}
