package com.example.solutionx.UI

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.CoantentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.solutionx.APIService.AirQualityApiService
import com.example.solutionx.model.HeatmapTileResponse
import com.example.solutionx.model.MapType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.reflect.Modifier

@Composable
fun HeatmapComponent(
    type: MapType,
    zoom: Int,
    x: Int,
    y: Int,
    airQualityApiService: AirQualityApiService
) {
    val heatmapTile = remember { mutableStateOf<Bitmap?>(null) }

    LaunchedEffect(Unit) {
        val response = getHeatmapTileResponse(type, zoom, x, y, airQualityApiService)

        if (response != null && response.isSuccessful) {
            heatmapTile.value = response.data.asImageBitmap()
        } else {
            // Update the value of heatmapTile only if the response is not successful
            response?.let {
                heatmapTile.value = it.data.asImageBitmap()
            }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            heatmapTile.value?.let { image ->
                Image(
                    bitmap = image,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
        // Add additional information adjacent to the heatmap
        // For example, add Text or other Composables here
    }
}

private fun ByteArray.asImageBitmap(): Bitmap? {
    return HeatmapTileResponse(ByteArray(0)).asImageBitmap()
}

private suspend fun getHeatmapTileResponse(
    type: MapType,
    zoom: Int,
    x: Int,
    y: Int,
    airQualityApiService: AirQualityApiService
): HeatmapTileResponse? {
    return withContext(Dispatchers.IO) {
        try {
            airQualityApiService.getHeatmapTile(type.name, zoom, x, y)
        } catch (e: Exception) {
            null
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeatmapComponentPreview() {
    HeatmapComponent(MapType.US_AQI, 2, 0, 1, AirQualityApiService.create())
}