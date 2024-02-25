package com.example.solutionx.UI


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.asImageBitmap
import com.example.solutionx.APIService.AirQualityClient.airQualityHeatMapApiService
import com.google.android.gms.common.api.Result
import okhttp3.ResponseBody
import retrofit2.Response

private val ResponseBody.isSuccessful: Unit
    get() = Unit

// Extension property to check if a Retrofit Response is successful
val <T : Result?> Response<T>.isSuccess: Boolean
    get() = isSuccessful

// Extension function to extract bytes from a ResponseBody
fun ResponseBody?.getBytes(): ByteArray? = this?.bytes()
@Composable
fun HeatmapComponent(type: String, zoom: Int, x: Int, y: Int) {
    val heatmapTile = remember { mutableStateOf<Bitmap?>(null) }


    LaunchedEffect(Unit) {
        val response = airQualityHeatMapApiService.getHeatmapTile(type, zoom, x, y)
        if (response.isSuccessful) {
            val responseBody = response.body()?.getBytes()
            if (responseBody != null) {
                BitmapFactory.decodeByteArray(responseBody, 0, responseBody.size)
                    .also { heatmapTile.value = it }
            }
        }
    }

    heatmapTile.value?.let { image ->
        Image(
            bitmap = image.asImageBitmap(),
            contentDescription = null
        )
    }
}

internal fun Any.getBytes(): ByteArray? {
    return getBytes()
}
