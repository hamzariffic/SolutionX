package com.example.solutionx.APIService

import com.google.type.LatLng
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface AirQualityApiService {
//    The current endpoint defines the location of the individual to provide the air quality data
    @POST("currentConditions:lookup?")
    suspend fun getCurrentConditions(
        @Body airQualityRequest: AirQualityRequest
        ): AirQualityResponse
    fun CurrentConditions(latitude: Any, longitude: Any): Any
}


interface HistoryEndpoint {
    @POST("history:lookup")
    suspend fun getHourlyHistory(
        @Body request: HistoryLookupRequest
    ): HistoryLookupResponse
}


//This is a data class for Air quality Data. Should be moved elsewhere
data class AirQualityRequest(
    val location: LatLng,
    val extraComputations: List<ExtraComputation>,
    val uaqiColorPalette: ColorPalette,
    val customLocalAqis: List<CustomLocalAqi>,
    val universalAqi: Boolean,
    val languageCode: String
)

data class AirQualityResponse(
    val dateTime: String,
    val regionCode: String,
    val indexes: List<AirQualityIndex>,
    val pollutants: List<Pollutant>,
    val healthRecommendations: HealthRecommendations
)


//This is a data class for history. Should be moved elsewhere
data class HistoryLookupRequest(
    val pageSize: Int,
    val pageToken: String,
    val location: LatLng,
    val extraComputations: List<ExtraComputation>,
    val uaqiColorPalette: ColorPalette,
    val customLocalAqis: List<CustomLocalAqi>,
    val timeRange: TimeRange,
    val universalAqi: Boolean,
    val languageCode: String
)

data class HistoryLookupResponse(
    val hoursInfo: List<HourInfo>,
    val regionCode: String,
    val nextPageToken: String
)

data class TimeRange(
    val dateTime: String,
    val hours: Int,
    val period: Interval
)

data class Interval(
    val startTime: String,
    val endTime: String
)