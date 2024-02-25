@file:Suppress("KotlinConstantConditions", "UNREACHABLE_CODE")

package com.example.solutionx.UI

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.solutionx.viewModels.AirQualityViewModel

@Composable
fun AirQualityDataComponent(viewModel: AirQualityViewModel) {
    val regionCode = null
    val request = regionCode?.let { AirQualityRequest(it) }
    val airQualityResponse by viewModel.airQualityData.observeAsState()

//Had to wrap it here since it's a suspend fun and I can't, presumably, create a coroutine composable
    LaunchedEffect(Unit) {
        viewModel.fetchAirQualityData(request!!)
    }
    airQualityResponse?.let { response ->
        Text(text = response.toString())
    }
    fun <T> LiveData<T>.observeAsState(): MutableState<T?> {
        val state = mutableStateOf<T?>(null)
        observeForever { state.value = it }
        return state
    }
}

@Composable
internal fun <T> LiveData<T>.observeAsState(): MutableState<T?> {
    val state = remember { mutableStateOf<T?>(null) }
    observeForever { state.value = it }
    return state
}

fun AirQualityRequest(regionCode: Any) {
    AirQualityRequest(regionCode = regionCode)
}

fun AirQualityResponse() {
    AirQualityResponse()
}

@Preview(showBackground = true)
@Composable
fun AirQualityDataComponentPreview() {
    val viewModel: AirQualityViewModel = viewModel()
    val hourlyHistoryResponse = listOf<com.example.solutionx.model.HourlyInfo>()
    AirQualityDataComponent(viewModel)
    HourlyHistoryDataComponent(hourlyHistoryResponse)
}