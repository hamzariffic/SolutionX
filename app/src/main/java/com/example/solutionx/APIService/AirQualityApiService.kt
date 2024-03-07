package com.example.solutionx.APIService

import com.example.solutionx.model.AirQualityResponse
import com.example.solutionx.model.HeatmapTileResponse
import com.example.solutionx.model.HistoryResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface AirQualityApiService {
    @POST("currentConditions?:lookup=API_KEY")
    suspend fun currentConditions(
        @Body airQualityRequest: AirQualityRequest
    ): AirQualityResponse

    fun Any?.getAirQualityHistory(
        historyRequest: HistoryLookupRequest
    ): HistoryResponse
    fun getHeatmapTile(type: String, zoom: Int, x: Int, y: Int): Nothing?
    fun getAirQualityHistory(historyRequest: HistoryLookupRequest) {
        null.getAirQualityHistory(historyRequest)
    }

    companion object {
        private const val BASE_URL = "https://airquality.googleapis.com/v1/currentConditions:lookup?key=API_KEY"

        fun create(): AirQualityApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(AirQualityApiService::class.java)
        }
    }}

interface History{
    @POST("history?:lookup=API_KEY")
    suspend fun getAirQualityHistory(
        @Body historyLookupRequest: Unit
    ): List<HistoryLookupRequest>

    companion object {
        private const val BASE_URL_History = "https://airquality.googleapis.com/v1/"
        fun create(): AirQualityApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL_History)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(AirQualityApiService::class.java)
        }
    }}

interface HeatmapTile {
    val data: Any

    @GET("heatmapTiles?/{type}/{zoom}/{x}/{y}")
    suspend fun getHeatmapTile(
        @Path("type") type: String,
        @Path("zoom") zoom: Int,
        @Path("x") x: Int,
        @Path("y") y: Int
    ): HeatmapTileResponse

    fun getHeatmapTile() {
        getHeatmapTile()
    }

    companion object {
        private const val BASE_URL = "https://airquality.googleapis.com/v1/"

        fun create(): AirQualityApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(AirQualityApiService::class.java)
        }
    }}
