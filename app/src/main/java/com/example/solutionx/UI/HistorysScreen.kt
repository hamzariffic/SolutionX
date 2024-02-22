package com.example.solutionx.UI

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.solutionx.model.CustomLocalAqi
import com.example.solutionx.model.ExtraComputation
import com.example.solutionx.model.HistoricalDataResponse
import com.example.solutionx.model.HistoryLookupRequest
import com.example.solutionx.ui.theme.SolutionXTheme
import com.example.solutionx.viewModels.HistoryViewModel
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch

@Composable
fun HistoryScreen(historyViewModel: HistoryViewModel = viewModel()) {
    // Define state for history data
    val historyData = remember { mutableStateOf<HistoricalDataResponse?>(null) }

    // Coroutine scope for handling async operations
    val coroutineScope = rememberCoroutineScope()

    //  Request parameters
    val request = HistoryLookupRequest(
        pageSize = 10,
        pageToken = "token123",
        location = LatLng(37.7749, -122.4194),
        extraComputations = ExtraComputation.entries,
        uaqiColor = android.graphics.Color(),
        customLocalAqis = listOf(CustomLocalAqi("Air", 1)),
        timeRange = TimeRange(),
        universalAqi = true,
        languageCode = "en"
    )

    // Function to fetch air quality history data
    fun fetchHistoryData(request: HistoryLookupRequest) {
        coroutineScope.launch {
            historyData.value = historyViewModel.fetchAirQualityHistory(historyRequest = request)
        }
    }

    // Call fetchHistoryData with appropriate request parameters
    fetchHistoryData(request)
    HistoricalDataResponse()
    // UI layout to display historical air quality data
    SolutionXTheme {
        Column {
            Text("Historical Air Quality Data")

            // Display historical air quality data
            historyData.value?.let { historyResponse ->
                // Display data here using Text or other composable functions
                // Example:
                Text("Data: $historyResponse")
            }
        }
    }
}

fun TimeRange() {
    TimeRange()
}
fun HistoricalDataResponse() {
    HistoricalDataResponse()
}
