@file:Suppress("DEPRECATION", "KotlinConstantConditions", "UNREACHABLE_CODE")

package com.example.solutionx.UI

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import com.example.solutionx.model.AirQualityRequest
import com.example.solutionx.viewModels.AirQualityViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun AirQualityDataComponent(viewModel: AirQualityViewModel) {
    val regionCode = null
    val request = regionCode?.let { AirQualityRequest(it) }
    val airQualityResponse by viewModel.airQualityData.observeAsState()

    viewModel.fetchAirQualityData(request!!)

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
fun AirQualityViewModel.AirQualityDataComponent(request: AirQualityRequest) {
    val airQualityResponse by airQualityData.observeAsState()

    fetchAirQualityData(request)

    airQualityResponse?.let { response ->
        Text(text = response.toString())
    }
}

@Composable
private fun <T> LiveData<T>.observeAsState(): MutableState<T?> {
    val state = remember { mutableStateOf<T?>(null) }
    observeForever { state.value = it }
    return state
}

fun AirQualityRequest(regionCode: Any) {
    AirQualityRequest(regionCode = regionCode)
}

private fun CoroutineScope.fetchAirQualityData(viewModel: AirQualityRequest) {
    fetchAirQualityData(viewModel)
}

fun AirQualityResponse() {
    AirQualityResponse()
}
