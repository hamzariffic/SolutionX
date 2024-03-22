package com.example.solutionx.UI

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.solutionx.model.HistoryLookupRequest
import com.example.solutionx.model.HistoryResponse
import com.example.solutionx.ui.theme.SolutionXTheme
import com.example.solutionx.viewModels.HistoryViewModel
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.launch
import retrofit2.HttpException


@Composable
fun HistoryScreen(
    navController: NavController
    historyViewModel: HistoryViewModel = viewModel()
) {
    val historyData = remember { mutableStateOf<HistoryResponse?>(null) }
    val error = remember { mutableStateOf<String?>(null) }
    val isLoading = remember { mutableStateOf(false) }

    val historyLookupRequest = HistoryLookupRequest(
        pageSize = 10,
        pageToken = "",
        location = LatLng(37.7749, -122.4194)
    )

    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    fun fetchHistoryData() {
        isLoading.value = true
        val coroutineScope = rememberCoroutineScope()
        coroutineScope?.launch {
            try {
                val response: LiveData<HistoryResponse> =
                    historyViewModel.fetchAirQualityHistory(historyLookupRequest)
                historyData.value = response
            } catch (e: Exception) {
                when (e) {
                    is HttpException -> error.value = "Network error: ${e.message}"
                    else -> error.value = "Error fetching historical data: ${e.message}"
                }
            } finally {
                isLoading.value = false
            }
        }
    }

    LaunchedEffect(Unit) {
        fetchHistoryData()
    }

    SolutionXTheme {
        Column {
            // Search bar placeholder (implementation needed)
            // ...
            // Circular progress indicator for loading animation
            if (isLoading.value) CircularProgressIndicator() else Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

            )
            // Card for displaying historical air quality data
      {
          Card(modifier = Modifier
              .fillMaxWidth()
              .padding(16.dp), elevation = 4.dp) {
              Column(contentPadding = Modifier.padding(16.dp)) {
                  Text("Historical Air Quality Data")

                  error.value?.let { errorMessage ->
                          Text(errorMessage, color = MaterialTheme.colorScheme.error)
                      }

                  historyData.value?.let { historyResponse ->
                      val data = historyResponse
                      for (item in data) Row {
                          Text(item.timestamp.toString())
                          Spacer(modifier = Modifier.width(8.dp))
                          OutlinedButton(
                              onClick = { /* handle AQI button click */ },
                              modifier = Modifier.weight(1f)
                          ) {
                              Text(item.aqi.toString())

                          }
                      }
                  }
              }
          }
            }
        }
    }
}

private fun ColumnScope.Card(modifier: Modifier, elevation: Dp, content: @Composable() (ColumnScope.() -> Unit)) {


}

@Composable
fun HistoryScreenPre() {
    HistoryScreen()
}