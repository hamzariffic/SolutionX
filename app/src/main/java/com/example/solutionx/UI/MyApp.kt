package com.example.solutionx.UI

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MyApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") { Home(navController) }
        composable("airQualityData") {
            // Your airQualityData composable content goes here
        }
        composable("HourlyHistoryDataComponent") {
            HourlyHistoryDataComponent(hourlyHistoryResponse = listOf())
        }
        composable("HeatMapData") {
            // Your HeatMapData composable content goes here
        }
        composable("AirQualityDataComponent") {
            // Your AirQualityDataComponent composable content goes here
        }
    }
}
