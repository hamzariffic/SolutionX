package com.example.solutionx.UI

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.solutionx.APIService.AirQualityApiService

@Composable
fun MyApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") { Home(navController) }
        composable("HeatMapData/{type}/{zoom}/{x}/{y}") { backStackEntry ->
            val type = backStackEntry.arguments?.getString("type") ?: ""
            val zoom = backStackEntry.arguments?.getInt("zoom") ?: 0
            val x = backStackEntry.arguments?.getInt("x") ?: 0
            val y = backStackEntry.arguments?.getInt("y") ?: 0
            HeatmapComponent(type, zoom, x, y, AirQualityApiService.create())
        }
        composable("HistoryScreen"){
            HistoryScreen(navController)
        }
        composable("HeatmapScreen"){
            HeatmapScreen()
        }
    }
}