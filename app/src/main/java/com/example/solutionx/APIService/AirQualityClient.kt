package com.example.solutionx.APIService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//This is the API's air quality client. It takes in the initial part of the API's URL

object AirQualityClient {
    private const val BASE_URL = "https://airquality.googleapis.com/v1/currentConditions:lookup?key=AIzaSyAiDHeFyGtYPO8Rz5ZvR__fp1TEfAQRKck"

//    currentConditions:lookup?
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val airQualityApiService: AirQualityApiService = retrofit.create(AirQualityApiService::class.java)
}