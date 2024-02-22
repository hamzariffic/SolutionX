@file:Suppress("DEPRECATION")

package com.example.solutionx.UI

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.solutionx.model.AirQualityRequest
import com.example.solutionx.viewModels.AirQualityViewModel

@Composable
fun AirQualityDataComponent(viewModel: AirQualityViewModel) {
    val request = AirQualityRequest(regionCode = regionCode)  // Assuming regionCode is defined
    val airQualityResponse by viewModel.airQualityData.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchAirQualityData(request)
    }

    airQualityResponse?.let { response ->
        Text(text = response.toString())
    }
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

@Preview
@Composable
fun AirQualityDataComponentPreview() {
    AirQualityDataComponent(
        viewModel = AirQualityViewModel()
    )
}

@Preview
@Composable
fun AirQualityDataComponenttPreview() {
    AirQualityDataComponent(viewModel = AirQualityViewModel())
}
