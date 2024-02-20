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
        @Body historyLookupRequest: HistoryRequest
    ): HistoryLookupResponse

    companion object {
        private const val BASE_URL = "https://your_base_url_here/"

        fun create(): AirQualityApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(AirQualityApiService::class.java)
        }
    }}
