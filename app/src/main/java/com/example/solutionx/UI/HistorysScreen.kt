package com.example.solutionx.UI

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.solutionx.model.HistoryResponse
import com.example.solutionx.ui.theme.SolutionXTheme
import com.example.solutionx.viewModels.HistoryViewModel
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch

@Composable
fun HistoryScreen(historyViewModel: HistoryViewModel = viewModel()) {
    // Define state for history data and error
    val historyData = remember { mutableStateOf<HistoryResponse?>(null) }
    val error = remember { mutableStateOf<String?>(null) }

    // Coroutine scope for handling async operations
    val coroutineScope = rememberCoroutineScope()

    // Request parameters
    val request = HistoryLookupRequest(
        pageSize = 10,
        pageToken = "",
        location = LatLng(37.7749, -122.4194),
        // Other request parameters...
    )

    // Function to fetch historical data
    fun fetchHistoryData(request: Unit) {
        coroutineScope.launch {
            try {
                val response = historyViewModel.fetchAirQualityHistory(request)
                historyData.value = response
            } catch (e: Exception) {
                error.value = "Error fetching historical data: ${e.message}"
            }
        }
    }

    // Call fetchHistoryData when the composable is first launched
    fetchHistoryData(request)

    // UI layout to display historical air quality data
    SolutionXTheme {
        Column {
            Text("Historical Air Quality Data")

            // Display any error
            error.value?.let { errorMessage ->
                Text(errorMessage)
            }

            // Display historical air quality data
            historyData.value?.let { historyResponse ->
                // Display data here using Text or other composable functions
                // Example:
                Text("Data: $historyResponse")
            }
        }
    }
}


fun HistoryLookupRequest(pageSize: Int, pageToken: String, location: LatLng) {
    HistoryLookupRequest(10, "", LatLng(37.7749, -122.4194))
}

fun TimeRange() {
    TimeRange()
}
fun HistoricalDataResponse() {
    HistoricalDataResponse()
}
