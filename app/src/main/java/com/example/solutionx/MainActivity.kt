package com.example.solutionx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.solutionx.UI.MyApp
import com.example.solutionx.ui.theme.SolutionXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SolutionXTheme {
                MyApp(navController)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    SolutionXTheme {
        // Define a preview composable if needed
    }
}
