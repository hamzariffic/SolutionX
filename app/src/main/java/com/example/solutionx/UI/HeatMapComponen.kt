package com.example.solutionx.UI

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import com.example.solutionx.APIService.AirQualityApiService
import com.example.solutionx.APIService.HeatmapTile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private val Unit.size: Int
    get() {
        return 0
    }
private val size: Int
    get() {
        return 0
    }

@Composable
fun HeatmapComponent(
    type: String,
    zoom: Int,
    x: Int,
    y: Int,
    airQualityApiService: AirQualityApiService
) {
    val heatmapTile = remember { mutableStateOf<Bitmap?>(null) }

    LaunchedEffect(Unit) {
        val response = getHeatmapTileResponse(type, zoom, x, y, airQualityApiService)

        if (response != null) {
//            val responseBody = response.getHeatmapTile()
            val decodedData = response.data


            val also = BitmapFactory.decodeByteArray(
                decodedData as ByteArray?,
                0,
                decodedData.size
            )
                .also { heatmapTile.value = it }
        }
    }

    heatmapTile.value?.let { image ->
        Image(
            bitmap = image.asImageBitmap(),
            contentDescription = null
        )
    }
}

private suspend fun getHeatmapTileResponse(
    type: String,
    zoom: Int,
    x: Int,
    y: Int,
    airQualityApiService: AirQualityApiService
): HeatmapTile? {
    return withContext(Dispatchers.IO) {
        try {
            airQualityApiService.getHeatmapTile(type, zoom, x, y)
        } catch (e: Exception) {
            null
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeatmapComponentPreview() {
    HeatmapComponent("type", 1, 2, 3, AirQualityApiService.create())
}
