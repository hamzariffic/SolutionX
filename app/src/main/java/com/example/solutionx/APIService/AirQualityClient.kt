package com.example.solutionx.APIService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.FileInputStream
import java.util.Properties

object AirQualityClient {
    private val apiKey: String by lazy {
        val properties = Properties()
        val localPropertiesFile = FileInputStream("local.properties")
        properties.load(localPropertiesFile)
        properties.getProperty("API_KEY") ?: throw IllegalStateException("API_KEY not found in local.properties")
    }
    private val BASE_URL = "https://airquality.googleapis.com/v1/currentConditions:lookup?key=$apiKey"
    private val BASE_URL_History = "https://airquality.googleapis.com/v1/history:lookup?key=$apiKey"
    private val BASE_URL_HeatMaps = "https://airquality.googleapis.com/v1/lookup?key=$apiKey"


//  AirQuality Client
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

//
    private val retrofitHistory = Retrofit.Builder()
        .baseUrl(BASE_URL_History)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

//  HeatMap Client
    private val retrofitHeatMaps = Retrofit.Builder()
        .baseUrl(BASE_URL_HeatMaps)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val airQualityHistoryApiService: AirQualityApiService = retrofitHistory.create(AirQualityApiService::class.java)

    val airQualityApiService: AirQualityApiService = retrofit.create(AirQualityApiService::class.java)}

