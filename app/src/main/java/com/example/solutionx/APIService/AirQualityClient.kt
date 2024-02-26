package com.example.solutionx.APIService

import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AirQualityClient {
    private const val API_KEY = "AIzaSyCR-4L-TbWGyM0agrwBsTLWN1HYa7T_2EY"

    private const val BASE_URL = "https://airquality.googleapis.com/v1/currentConditions:lookup?key=$API_KEY"
    private const val BASE_URL_History = "https://airquality.googleapis.com/v1/history:lookup?key=$API_KEY"
    private const val BASE_URL_HeatMaps = "https://airquality.googleapis.com/v1/lookup?key=$API_KEY"


//  AirQuality Client
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

//
    private val retrofitHistory = Retrofit.Builder()
        .baseUrl(BASE_URL_History)
        .addConverterFactory(GsonConaverterFactory.create())
        .build()

//  HeatMap Client
    private val retrofitHeatMaps = Retrofit.Builder()
        .baseUrl(BASE_URL_HeatMaps)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val airQualityApiService: AirQualityApiService = retrofit.create(AirQualityApiService::class.java)
    val airQualityHistoryApiService: AirQualityApiService = retrofitHistory.create(AirQualityApiService::class.java)
    val airQualityHeatMapApiService: AirQualityApiService = retrofitHeatMaps.create(AirQualityApiService::class.java)
}

class GsonConaverterFactory {
    companion object {
        fun create(): Converter.Factory {
            return GsonConverterFactory.create()
        }
    }
}

