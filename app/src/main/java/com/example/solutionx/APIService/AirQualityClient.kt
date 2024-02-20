package com.example.solutionx.APIService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AirQualityClient {
    private const val BASE_URL = "https://airquality.googleapis.com/v1/currentConditions:lookup?key=AIzaSyAiDHeFyGtYPO8Rz5ZvR__fp1TEfAQRKck"
    private const val BASE_URL_History = "https://airquality.googleapis.com/v1/history:lookup?key=AIzaSyAiDHeFyGtYPO8Rz5ZvR__fp1TEfAQRKck"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitHistory = Retrofit.Builder()
        .baseUrl(BASE_URL_History)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val airQualityApiService: AirQualityApiService = retrofit.create(AirQualityApiService::class.java)
    val airQualityHistoryApiService: AirQualityApiService = retrofitHistory.create(AirQualityApiService::class.java)
}
