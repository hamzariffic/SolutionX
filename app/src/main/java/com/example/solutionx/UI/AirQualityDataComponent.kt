@file:Suppress("DEPRECATION", "KotlinConstantConditions")

package com.example.solutionx.UI

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.solutionx.model.AirQualityRequest
import com.example.solutionx.viewModels.AirQualityViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun AirQualityDataComponent(viewModel: AirQualityViewModel) {
    val regionCode = null
    val request =
        regionCode?.let { AirQualityRequest(regionCode = it) }  // Assuming regionCode is defined
    val airQualityResponse by viewModel.airQualityData.observeAsState()

    LaunchedEffect(Unit) {
        request?.let { viewModel.fetchAirQualityData(it) }
    }

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

@Composable
fun AirQualityViewModel.AirQualityDataComponent(request: AirQualityRequest) {
    val airQualityResponse by airQualityData.observeAsState()

    LaunchedEffect(Unit) {
        fetchAirQualityData(request)
    }

    airQualityResponse?.let { response ->
        Text(text = response.toString())
    }
}

private fun CoroutineScope.fetchAirQualityData(viewModel: AirQualityRequest) {
    fetchAirQualityData(viewModel)
}

fun AirQualityResponse() {
    AirQualityResponse()
}

@Preview
@Composable
fun AirQualityDataComponentPreview() {
    AirQualityDataComponent(
        viewModel = AirQualityViewModel(viewModel())
    )
}

@Preview
@Composable
fun AirQualityDataComponenttPreview() {
    AirQualityDataComponent(viewModel = AirQualityViewModel(viewModel()))
}
