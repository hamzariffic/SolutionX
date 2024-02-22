package com.example.solutionx.UI

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MyApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") { Home(navController) }
        composable("airQualityDataComponent") {
            AirQualityDataComponent()
            HourlyHistoryDataComponent(hourlyHistoryResponse = listOf())
        }
        composable("HourlyHistoryDataComponent") {
            HourlyHistoryDataComponent(hourlyHistoryResponse = listOf())
        }
        composable("HeatMapData/{type}/{zoom}/{x}/{y}") { backStackEntry ->
            val type = backStackEntry.arguments?.getString("type") ?: ""
            val zoom = backStackEntry.arguments?.getInt("zoom") ?: 0
            val x = backStackEntry.arguments?.getInt("x") ?: 0
            val y = backStackEntry.arguments?.getInt("y") ?: 0
            HeatmapComponent(type, zoom, x, y)
        }
        composable("AirQualityDataComponent") {
            AirQualityDataComponent()        }
        composable("HistoryScreen"){
            HistoryScreen()
        }
    }
}