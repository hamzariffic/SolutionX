package com.example.solutionx.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solutionx.APIService.AirQualityApiService
import com.example.solutionx.BuildConfig.API_KEY
import com.example.solutionx.model.HistoryLookupRequest
import com.example.solutionx.model.HistoryResponse
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val Unit.endTime: Any
    get() {
        TODO("Not yet implemented")
    }
private val Unit.startTime: Any
    get() {
        TODO("Not yet implemented")
    }

class HistoryViewModel : ViewModel() {

    private val airQualityService: AirQualityApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://airquality.googleapis.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AirQualityApiService::class.java)
    }

    fun fetchAirQualityHistory(historyRequest: HistoryLookupRequest): LiveData<HistoryResponse> {
        val liveData = MutableLiveData<HistoryResponse>()
        viewModelScope.launch {
            try {
                val response = airQualityService.getHistory(
                    key = API_KEY,
                    location = historyRequest.location.latitude.toString() + "," + historyRequest.location.longitude.toString(),
                    pageSize = historyRequest.pageSize,
                    pageToken = historyRequest.pageToken,
                    timeRange = historyRequest.timeRange.startTime.toString() + "/" + historyRequest.timeRange.endTime.toString(),
                )
                liveData.postValue(response)
            } catch (e: Exception) {
                liveData.postValue(HistoryResponse(emptyList(), "", null, "", null, null, "", 0, null, null, null, null))
                Log.e("HistoryViewModel", "Error fetching history data: ${e.message}")
            }
        }
        return liveData
    }
}

private fun <T> MutableLiveData<T>.postValue(response: Unit) = Unit
