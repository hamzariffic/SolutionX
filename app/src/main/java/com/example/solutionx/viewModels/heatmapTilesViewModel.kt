package com.example.solutionx.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solutionx.APIService.AirQualityApiService
import com.example.solutionx.model.HeatmapTileResponse
import com.example.solutionx.model.MapType
import kotlinx.coroutines.launch

class HeatmapViewModel(private val airQualityApiService: AirQualityApiService) : ViewModel() {
    fun fetchHeatmapTile(type: MapType, zoom: Int, x: Int, y: Int) {
        viewModelScope.launch {
            val response = getHeatmapTileResponse(type, zoom, x, y)
            // Handle the response as needed
        }
    }

    private suspend fun getHeatmapTileResponse(
        type: MapType,
        zoom: Int,
        x: Int,
        y: Int
    ): HeatmapTileResponse? {
            return try {
                airQualityApiService.getHeatmapTile(type.name, zoom, x, y)
            } catch (e: Exception) {
                null
            }
    }
}
