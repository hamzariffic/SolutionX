package com.example.solutionx.model

import androidx.lifecycle.ViewModel
import com.example.solutionx.APIService.AirQualityApiService
import com.example.solutionx.APIService.HistoryLookupResponse
import com.example.solutionx.APIService.HistoryRequest

class HistoryViewModel<HistoryResponse> : ViewModel() {
    private val airQualityApiService = AirQualityApiService.create()

    suspend fun fetchAirQualityHistory(request: HistoryRequest): HistoryLookupResponse {
        return airQualityApiService.getAirQualityHistory(request)
    }
}
