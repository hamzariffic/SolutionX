package com.example.solutionx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.solutionx.ui.theme.SolutionXTheme
import com.google.api.Http
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolutionXTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Hamza")
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.primary)
        .height(200.dp)) {
        Text(
            text = "Hello $name!",
            modifier = modifier.align(alignment = Alignment.Center)
        )
    }
}

@Composable
fun WeightSliderRow(
    initialWeight: Float,
    userId: String,
    onValueChanged: (Float) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    var weight by remember { mutableStateOf(initialWeight) }

    // Fetch user data from the backend
    val userWeight = remember { mutableStateOf(0f) }
    LaunchedEffect(userId) {
        coroutineScope.launch {
            val response = async { getRemoteUserData(userId) }
            val data = response.await().weight
            userWeight.value = data
        }
    }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Your weight:")
        Slider(
            value = weight,
            onValueChange = {
                weight = it
                onValueChanged(it)
            },
            valueRange = 0f..userWeight.value
        )
        Text(text = "${weight} kg")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SolutionXTheme {
        Greeting("Hamza")
    }
}

@Preview(showBackground = true)
@Composable
fun WeightSliderRowPreview() {
    SolutionXTheme {
        WeightSliderRow()
    }
}