package com.example.solutionx.UI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.solutionx.ui.theme.SolutionXTheme

@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Buttons
        ElevatedButton(onClick = { navController.navigate("historyScreen") }) {
            Text("View History")
        }
        Spacer(modifier = Modifier.height(16.dp))
        ElevatedButton(onClick = { navController.navigate("heatmapScreen") }) {
            Text("View Heatmap")
        }
        Spacer(modifier = Modifier.height(16.dp))
        ElevatedButton(onClick = { navController.navigate("extraComputationsScreen") }) {
            Text("View Extra Computations")
        }

        // Text box for user input
        OutlinedTextField(
            value = "",
            onValueChange = { /* Handle value change */ },
            label = { Text("Enter your prompt") },
            singleLine = true,
            modifier = Modifier.padding(top = 24.dp)
        )
    }
}


@Composable
fun <T> LiveData<T>.observeAsState(initialValue: T): State<T> {
    val state = remember { mutableStateOf(initialValue) }
    val observer = Observer<T> { value ->
        state.value = value
    }
    observeForever(observer)
    DisposableEffect(this) {
        onDispose {
            removeObserver(observer)
        }
    }
    return state
}

@Preview()
@Composable
fun HomePreview() {
    SolutionXTheme {
        Home(navController = rememberNavController())
    }
}


