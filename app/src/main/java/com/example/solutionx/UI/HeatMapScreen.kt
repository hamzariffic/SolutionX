import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.example.solutionx.model.HeatmapTileResponse
import com.example.solutionx.model.MapType.US_AQI

@Composable
fun HeatmapScreen(airQualityApiService: Nothing?) {
    val heatmapTile = remember { mutableStateOf<Bitmap?>(null) }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { fetchHeatmapData(
            airQualityApiService = airQualityApiService,
            heatmapTile = heatmapTile
        ) }) {
            Text("Toggle Heatmap")
        }

        heatmapTile.value?.let {
            HeatmapComponent(it)
        }
    }
}

@Composable
private fun HeatmapComponent(heatmapBitmap: Bitmap) {
    Image(
        bitmap = ImageBitmap(heatmapBitmap),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
private fun fetchHeatmapData(
    airQualityApiService: Nothing?,
    heatmapTile: MutableState<Bitmap?>
) {
    LaunchedEffect(Unit) {
        val response = airQualityApiService?.let {
            HeatmapTileResponse(
                US_AQI.toString(), 2, listOf(0), 1.toString(),
                it
            )
        }
        response?.let {
            if (it.isSuccessful) {
                heatmapTile.value = it.data
            }
        }
    }
}

@Preview
@Composable
fun HeatMapScreen() {
    val airQualityApiService = null
    HeatmapScreen(airQualityApiService)
}