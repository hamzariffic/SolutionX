package com.example.solutionx.UI


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun <heatMapResponse> HeatmapDataComponent(heatmapResponse: heatMapResponse) {
    Text(text = heatmapResponse.toString())
}
