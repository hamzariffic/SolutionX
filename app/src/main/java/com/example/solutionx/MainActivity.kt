package com.example.solutionx.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.solutionx.UI.Home
import com.example.solutionx.UI.MyApp
import com.example.solutionx.ui.theme.SolutionXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolutionXTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorScheme.background
                ) {
                    Home(navController = rememberNavController())
                }
                val navController = rememberNavController()
                MyApp(navController)
            }
        }
    }
}




//@file:Suppress("PreviewMustBeTopLevelFunction")
//
//package com.example.solutionx
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.material3.ElevatedButton
//import androidx.compose.material3.FilledTonalButton
//import androidx.compose.material3.FloatingActionButton
//import androidx.compose.material3.MaterialTheme.colorScheme
//import androidx.compose.material3.OutlinedButton
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.NavController
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.solutionx.ui.theme.SolutionXTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            SolutionXTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = colorScheme.background
//                ) {
//                    Home(navController = rememberNavController())
//                }
//                val navController = rememberNavController()
//                MyApp(navController)
//            }
//        }
//    }
//}
//
//@Composable
//fun MyApp(navController: NavHostController) {
//        NavHost(navController = navController, startDestination = "Home") {
//            composable("Home") { Home(navController) }
//            composable("airQualityData") {
//        }
//    }
//}
//
//
//@Composable
//fun Home(navController: NavController) {
//    val expanded = remember { mutableStateOf(false) }
//
//    Row {
//        OutlinedButton(onClick = {
//            navController.navigate("AirQualityScreen")
//        }) {
//            Text(text = "Air\uD83D\uDCA8")
//        }
//        Spacer(modifier = Modifier.weight(0.3f))
//
//        FilledTonalButton(onClick = { expanded.value = !expanded.value }) {
//            Text(
//                text = if (expanded.value) {
//                    "Solar\uD83C\uDF1E"
//                } else {
//                    "Solar intensity data"
//                })
//        }
//        Spacer(modifier = Modifier.weight(0.3f))
//
//        FloatingActionButton(onClick = {
//            expanded.value = !expanded.value
//        }) {
//            Text(text = if (expanded.value) "Ocean" else "Ocean\uD83C\uDF0A")
//        }
//        Spacer(modifier = Modifier.weight(0.3f))
//
//        FilledTonalButton(onClick = { /*TODO*/ }) {
//            Text(text = "SDG")
//        }
//    }
//
//    Column(modifier = Modifier.fillMaxWidth()) {
//        ElevatedButton(onClick = { expanded.value = !expanded.value }) {
//            Text(
//                text = if (expanded.value) {
//                    "Click learn more about these buttons\uD83D\uDE0A"
//                } else {
//                    "Spoiler alert! It's about Air Quality & Solar Intensity"
//                }
//            )
//        }
//    }
////    Need to
//}
//
//@Preview(showBackground = true)
//@Composable
//fun HomePreview() {
//    SolutionXTheme {
//        Home(navController = rememberNavController())
//    }
//}