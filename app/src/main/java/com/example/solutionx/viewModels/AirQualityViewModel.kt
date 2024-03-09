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
            val airQualityRequest = AirQualityRequest(
                location = currentLocation,
                extraComputations = emptyList(),
                customLocalAqis = emptyList(),
                universalAqi = false,
                languageCode = "en"
            )
            when (val result = airQualityRepository.fetchAirQualityData(airQualityRequest)) {
                is AirQualityRepository.Result.Success -> {
                    result.data.also {
                        _airQualityData.value = AirQualityResponse()
                    }
                    _errorLiveData.value = null
                }

                is AirQualityRepository.Result.Error -> {
                    _errorLiveData.value = result.message
                    _airQualityData.value = null
                }

                else -> {
                    _errorLiveData.value = "Unexpected error occurred"
                    _airQualityData.value = null
                }
            }
            _loadingState.value = false
        }
    }
}