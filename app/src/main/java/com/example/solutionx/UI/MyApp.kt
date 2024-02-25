package com.example.solutionx.UI

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.solutionx.APIService.AirQualityApiService
import com.example.solutionx.model.HealthRecommendations

@Composable
fun MyApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") { Home(navController) }
        composable("airQualityDataComponent") {
            AirQualityDataComponent(viewModel())
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
            HeatmapComponent(type, zoom, x, y, AirQualityApiService.create())
        }
        composable("HistoryScreen"){
            HistoryScreen(navController)
        }
        composable("HealthRecommendationsScreen"){
            HealthRecommendationsScreen(
                navController,
                healthRecommendations = HealthRecommendations()
            )
        }
        composable("HeatmapScreen"){
            HeatmapScreen()
        }
    }
}