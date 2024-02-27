package com.example.solutionx.viewModels

import androidx.lifecycle.ViewModel
import com.example.solutionx.model.HistoryResponse

class HistoryViewModel : ViewModel() {
    fun fetchAirQualityHistory(historyRequest: com.example.solutionx.model.HistoryLookupRequest): HistoryResponse {
        return HistoryResponse(emptyList(), "", null, "", null, null, "", 0, null, null, null, null)

    }
}