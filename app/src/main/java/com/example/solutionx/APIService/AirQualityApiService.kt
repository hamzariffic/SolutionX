package com.example.solutionx.APIService

import com.example.solutionx.model.AirQualityResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface AirQualityApiService {
    @POST("currentConditions:lookup")
    suspend fun currentConditions(
        @Body airQualityRequest: String
    ): AirQualityResponse

    @POST("history:lookup")
    suspend fun getAirQualityHistory(
        @Body historyLookupRequest: HistoryLookupRequest
    ): HistoryLookupResponse

    companion object
}

//object AirQualityClient {
//    private const val BASE_URL = "https://airquality.googleapis.com/v1/"
//
//    private val retrofit: Retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val airQualityApiService: AirQualityApiService = retrofit.create(AirQualityApiService::class.java)
//}

