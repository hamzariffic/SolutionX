package com.example.solutionx.viewModels

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.solutionx.model.Location
import com.google.android.gms.location.LocationServices

class LocationViewModel(context: Context) : ViewModel() {

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