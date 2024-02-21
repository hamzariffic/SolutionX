package com.example.solutionx.UI

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
//import  com.example.solutionx.UI.HeatmapDataComponent

@Composable
fun MyApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") { Home(navController) }
        composable("airQualityDataComponent") {
            AirQualityDataComponent()        }
        composable("HourlyHistoryDataComponent") {
            HourlyHistoryDataComponent(hourlyHistoryResponse = listOf())
        }
        composable("HeatMapData") {
//            HeatmapDataComponent()
        }
        composable("AirQualityDataComponent") {
            AirQualityDataComponent()        }
//        composable("")
    }
}
