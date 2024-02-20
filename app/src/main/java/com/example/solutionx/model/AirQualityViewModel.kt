package com.example.solutionx.model

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.solutionx.APIService.AirQualityApiService
import com.google.android.gms.location.LocationServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AirQualityViewModel(private val apiService: AirQualityApiService) : ViewModel() {
    class AirQualityViewModel(private val apiService: AirQualityApiService) : ViewModel() {
        private val _airQualityData by lazy { MutableLiveData<AirQualityResponse>() }
        val airQualityData: LiveData<AirQualityResponse> get() = _airQualityData

        suspend fun fetchAirQualityData(airQualityRequest: AirQualityRequest) {
            val call: Call<AirQualityResponse> = apiService.currentConditions(airQualityRequest.toString())
            call.enqueue(object : Callback<AirQualityResponse> {
                override fun onResponse(call: Call<AirQualityResponse>, response: Response<AirQualityResponse>) {
                    if (response.isSuccessful) {
                        _airQualityData.value = response.body()
                    } else {
                        println("Could not get Air Quality Conditions")
                    }
                }
                override fun onFailure(call: Call<AirQualityResponse>, t: Throwable) {
                    println("Network request failed: ${t.message}")
                }
            })
        }
    }


class LocationViewModel(context: Context) : ViewModel() {

    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    private val _userLocation = MutableLiveData<Location>()
    val userLocation: LiveData<Location> = _userLocation

    @SuppressLint("MissingPermission")
    fun fetchUserLocation() {
        fusedLocationClient.lastLocation.addOnSuccessListener {
            _userLocation.value = Location(it.latitude, it.longitude)
        }
    }}
}
