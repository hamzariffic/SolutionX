package com.example.solutionx.model

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solutionx.APIService.AirQualityApiService
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

class AirQualityViewModel(private val apiService: AirQualityApiService) : ViewModel() {
    private val _airQualityData = MutableLiveData<AirQualityResponse>()
    val airQualityData: LiveData<AirQualityResponse> get() = _airQualityData

    fun fetchAirQualityData(airQualityRequest: AirQualityRequest) {
        viewModelScope.launch {
            try {
                val call = apiService.CurrentConditions(airQualityRequest)
                val response = call.awaitResponse()

                if (response.isSuccessful) {
                    _airQualityData.value = response.body()
                } else {
                    println("Could not get Air Quality Conditions")
                }
            } catch (e: Exception) {
                println("Could not get Air Quality Conditions")}
        }
    }
}

class LocationViewModel : ViewModel() {

    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    private val _userLocation = MutableLiveData<Location>()
    val userLocation: LiveData<Location> = _userLocation

    @SuppressLint("MissingPermission")
    fun fetchUserLocation() {
        fusedLocationClient.lastLocation.addOnSuccessListener {
            _userLocation.value = Location(it.latitude, it.longitude)
        }
    }
}
