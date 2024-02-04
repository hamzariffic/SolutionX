@file:Suppress("NAME_SHADOWING")

package com.example.solutionx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
    Column(modifier = Modifier.fillMaxWidth()){
        ElevatedButton(onClick = {expanded.value = !expanded.value}) {
            Box {
                Text(text = if (expanded.value) "Show less" else "Show more"
                )
            } }
        OutlinedButton(onClick = { }) {
            Text(text = "Button X")
            
        }
        FilledTonalButton(onClick = { /*TODO*/ }) {
            Text(text = "Toned Up")
        }
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Text(text = "Floating")
            
        }
        FilledIconButton(onClick = { /*TODO*/ }) {
            Text(text = "Icon")
        }
    }
    Row(modifier = Modifier) {
        Box {
            IconButton(onClick = { /*TODO*/ }) {
                 Modifier.background(color = Color.Magenta)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SolutionXTheme {
        Greeting("Hamza")
    }
}
