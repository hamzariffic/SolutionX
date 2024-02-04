@file:Suppress("NAME_SHADOWING")

package com.example.solutionx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.solutionx.ui.theme.SolutionXTheme

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
    val name : List<String> = listOf("Hamza", "Ali", "Ahmed")
    var expanded = remember {
        mutableStateOf(false)
    }
    var expanded2 = remember { mutableStateOf(false) }
    var expanded3 = remember { mutableStateOf(false) }

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
            OutlinedButton(onClick = { }) {
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

            FilledTonalButton(onClick = {expanded2.value = !expanded.value}) {
                Text(text = "AI")
            }
            Spacer(modifier = Modifier.weight(1f))

            FilledIconButton(onClick = { /*TODO*/ }) {
                Text(text = "SDG")
            }
        }
        IconButton(onClick = { /*TODO*/ }) {
            Modifier.background(color = Color.Magenta)
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
