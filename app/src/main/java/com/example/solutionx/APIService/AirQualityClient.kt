package com.example.solutionx.APIService

object AirQualityClient {
    private const val BASE_URL = "https://api.airquality.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val airQualityApiService: AirQualityApiService = retrofit.create(AirQualityApiService::class.java)
}