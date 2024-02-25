package com.example.solutionx.UI

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.solutionx.model.MapType

@Composable
fun HeatmapScreen() {
    var showHeatmap by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { showHeatmap = !showHeatmap }) {
            Text(if (showHeatmap) "Hide Heatmap" else "Show Heatmap")
        }

        if (showHeatmap) {
            HeatmapComponent(type = MapType.US_AQI, zoom = 2, x = 0, y = 1)
        }
    }
}
