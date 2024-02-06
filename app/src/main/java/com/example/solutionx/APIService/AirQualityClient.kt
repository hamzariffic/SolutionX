package com.example.solutionx.APIService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AirQualityClient {
    private const val BASE_URL = "https://airquality.googleapis.com/v1/"
//    currentConditions:lookup?

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val airQualityApiService: AirQualityApiService = retrofit.create(AirQualityApiService::class.java)
}