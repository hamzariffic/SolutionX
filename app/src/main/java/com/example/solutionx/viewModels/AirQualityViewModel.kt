package com.example.solutionx.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.solutionx.APIService.AirQualityRequest
import com.example.solutionx.APIService.AirQualityResponse
import com.example.solutionx.Repository.AirQualityRepository
import kotlinx.coroutines.launch


class AirQualityViewModel(
    private val airQualityRepository: AirQualityRepository,
    private val locationViewModel: LocationViewModel
) : ViewModel() {
    private val _airQualityData = MutableLiveData<AirQualityResponse?>()
    val airQualityData: MutableLiveData<AirQualityResponse?> = _airQualityData

    private val _errorLiveData = MutableLiveData<String?>()
    val errorLiveData: MutableLiveData<String?> = _errorLiveData

    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> = _loadingState

    fun fetchAirQualityData(request: com.example.solutionx.model.AirQualityRequest) {
        viewModelScope.launch {
            _loadingState.value = true
            val currentLocation = locationViewModel.getCurrentLocation()
            val request = AirQualityRequest(location = currentLocation)
            when (val result = airQualityRepository.fetchAirQualityData(request)) {
                is Result.Success -> {
                    _airQualityData.value = result.data
                    _errorLiveData.value = null
                }
                is Result.Error -> {
                    _errorLiveData.value = result.message
                    _airQualityData.value = null
                }

                else -> {}
            }
            _loadingState.value = false
        }
    }
}