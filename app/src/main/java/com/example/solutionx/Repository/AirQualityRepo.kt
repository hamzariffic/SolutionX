package com.example.solutionx.Repository

import android.os.Parcel
import android.os.Parcelable
import com.example.solutionx.APIService.AirQualityApiService
import com.example.solutionx.APIService.AirQualityRequest
import com.example.solutionx.model.AirQualityResponse

// This class will handle the API calls and data fetching logic. We will use it to fetch air quality data
// "Result" or "Either approach"
class AirQualityRepository(private val apiService: AirQualityApiService) {

    suspend fun fetchAirQualityData(request: AirQualityRequest): Result<AirQualityResponse> {
        return try {
            val response = apiService.currentConditions(request)
            if (response.isSuccessful) response.body()?.let { Result.Success<AirQualityResponse>(it) }
                ?: Result.Error("Empty response body") else {
                Result.Error("Could not get Air Quality Conditions: ${response.message()}")
            }
        } catch (e: Exception) {
            Result.Error("Network request failed: ${e.message}")
        }
    }

    sealed class Result<out T> {
        data class Success<out T>(val data: Unit) : Result<T>()
        data class Error(val message: String?) : Result<Nothing>(), Parcelable {
            constructor(parcel: Parcel) : this(parcel.readString())

            override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(message)
            }

            override fun describeContents(): Int {
                return 0
            }

            companion object CREATOR : Parcelable.Creator<Error> {
                override fun createFromParcel(parcel: Parcel): Error {
                    return Error(parcel)
                }

                override fun newArray(size: Int): Array<Error?> {
                    return arrayOfNulls(size)
                }
            }
        }

        companion object {
            fun <T> Success(data: T): Success<T> {
                return Success(data as T)
            }
        }
    }
}