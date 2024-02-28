package com.example.solutionx.UI

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.solutionx.model.ExtraComputation

@Composable
fun ExtraComputationListComponent(extraComputations: List<ExtraComputation>) {
    LazyColumn {
        items(extraComputations) { extraComputation ->
            Text(text = extraComputation.toString())
        }
    }
}

@Preview
@Composable
fun PreviewExtraComputationListComponent() {
    val extraComputationList = ExtraComputation.entries
    ExtraComputationListComponent(extraComputationList)
}
