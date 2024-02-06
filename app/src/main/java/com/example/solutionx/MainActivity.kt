@file:Suppress("NAME_SHADOWING")

package com.example.solutionx

/* import androidx.compose.material3.FilledIconButton */
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.solutionx.UI.AirQualityData
import com.example.solutionx.ui.theme.SolutionXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolutionXTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController() // We're creating a NavController instance

                NavHost(navController = navController, startDestination = "greeting") {
                    composable("greeting") { Greeting("Hamza") } // Pass navController
                    composable("airQualityData") { AirQualityData(airData = airData) }

                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = colorScheme.background
                    ) {
                        Greeting("Hamza")
                    }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val name : List<String> = listOf("Hamza", "Ali", "Ahmed")
    var expanded = remember { mutableStateOf(false) }
    var expanded2 = remember { mutableStateOf(false) }
    var expanded3 = remember { mutableStateOf(false) }
    var expanded4 = remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
//        This is the expandable button for the UI so far! It's kinda murky but I'm gonna clean it with time
        ElevatedButton(onClick = { expanded.value = !expanded.value }) {
            Text(
                text = if (expanded.value) {
                    "Click learn more about these buttons\uD83D\uDE0A"
                } else {
                    "Spoiler alert! It's about Air Quality & Solar Intensity"
                }
            )
        }

//I've nested these buttons to where I need to add some onClick logic to perform specific actions!
        Row( modifier = Modifier.weight(1f)) {
//            Air Quality data
            OutlinedButton(onClick = {navController.navigate("airQuality") // Adjust destination route as needed }) {
                Text(text = "Air\uD83D\uDCA8")

            }
            Spacer(modifier = Modifier.weight(0.3f))

//      Solar intensity data
            FilledTonalButton(onClick = { expanded2.value = !expanded2.value }) {
                Text(
                    text = if (expanded2.value) {
                        "Solar\uD83C\uDF1E"
                    } else {
                        "Solar intensity data"
                    })
            }
            Spacer(modifier = Modifier.weight(0.3f))

//       Ocean data
            FloatingActionButton(onClick = {
                expanded3.value = !expanded3.value
            }) {
                Text(text = if (expanded3.value) "Ocean" else "Ocean\uD83C\uDF0A")
            }
            Spacer(modifier = Modifier.weight(0.3f))

            FilledTonalButton(onClick = {expanded4.value = !expanded4.value}) {
                Text(text = if(expanded4.value) "AI" else "\uD83E\uDD16")
            }
            Spacer(modifier = Modifier.weight(1f))


//            FilledIconButton(onClick = { /*TODO*/ }) {
//                Text(text = "SDG")
//            }
        }
        Row(modifier = Modifier.weight(1f)
            .height(IntrinsicSize.Max)
            .align(Alignment.Start)
            .fillMaxWidth()) {
            Card(modifier = Modifier.height(intrinsicSize = IntrinsicSize.Max).weight(1f)) {
                Text(text = "Air Quality Index: 2.5")
                Text(text = "Solar Intensity: 2.5")
                Text(text = "Ocean Index: 2.5")
                Text(text = "AI Index: 2.5")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SolutionXTheme {
        Greeting("Hamza Y")
    }
}
