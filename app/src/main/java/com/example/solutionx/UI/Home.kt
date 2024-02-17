package com.example.solutionx.UI


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.solutionx.ui.theme.SolutionXTheme

@Composable
fun Home(navController: NavController) {
    val expanded = remember { mutableStateOf(false) }

    Row {
        OutlinedButton(onClick = {
            navController.navigate("AirQualityScreen")
        }) {
            Text(text = "Air\uD83D\uDCA8")
        }
        Spacer(modifier = Modifier.weight(0.3f))

        FilledTonalButton(onClick = { expanded.value = !expanded.value }) {
            Text(
                text = if (expanded.value) {
                    "Solar\uD83C\uDF1E"
                } else {
                    "Solar intensity data"
                })
        }
        Spacer(modifier = Modifier.weight(0.3f))

        FloatingActionButton(onClick = {
            expanded.value = !expanded.value
        }) {
            Text(text = if (expanded.value) "Ocean" else "Ocean\uD83C\uDF0A")
        }
        Spacer(modifier = Modifier.weight(0.3f))

        FilledTonalButton(onClick = { /*TODO*/ }) {
            Text(text = "SDG")
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        ElevatedButton(onClick = { expanded.value = !expanded.value }) {
            Text(
                text = if (expanded.value) {
                    "Click learn more about these buttons\uD83D\uDE0A"
                } else {
                    "Spoiler alert! It's about Air Quality & Solar Intensity"
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    SolutionXTheme {
        Home(navController = rememberNavController())
    }
}
