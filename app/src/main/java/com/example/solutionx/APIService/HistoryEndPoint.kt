package com.example.solutionx.APIService

import com.google.type.LatLng
import retrofit2.http.Body
import retrofit2.http.POST

interface HistoryEndpoint {
    @POST("history:lookup")
    suspend fun getHourlyHistory(
        @Body request: HistoryLookupRequest
    ): HistoryLookupResponse
}
