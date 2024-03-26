package com.example.solutionx.model

import android.os.Parcel
import android.os.Parcelable

data class hourlyInfo(
    val dateTime: String,
    val indexes: List<AirQualityIndex>,
    val pollutants: List<Pollutant<Any?>>,
    val healthRecommendations: HealthRecommendations
)

data class AirQualityIndex(
    val category: String,
    val description: String,
    val name: String,
    val localizedName: String,
    val dominantPollutant: String,
    val dominantPollutantDescription: String,
    val level: String,
    val color: String,
    val categoryNumber: Int
)

data class Pollutant<T>(
    val name: String?,
    val conc: Double,
    val concUnit: String?,
    val aqi: Int,
    val category: String,
    val categoryNumber: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeDouble(conc)
        parcel.writeString(concUnit)
        parcel.writeInt(aqi)
        parcel.writeString(category)
        parcel.writeInt(categoryNumber)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pollutant<Any?>> {
        override fun createFromParcel(parcel: Parcel): Pollutant<Any?> {
            return Pollutant(parcel)
        }

        override fun newArray(size: Int): Array<Pollutant<Any?>?> {
            return arrayOfNulls(size)
        }
    }
}

data class HealthRecommendations(
    val generalPopulation: String,
    val elderly: String?,
    val lungDiseasePopulation: String,
    val heartDiseasePopulation: String,
    val athletes: String,
    val pregnantWomen: String?,
    val children: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString(),
        parcel.readString().toString()
    )

    constructor() : this(

    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(generalPopulation)
        parcel.writeString(elderly)
        parcel.writeString(lungDiseasePopulation)
        parcel.writeString(heartDiseasePopulation)
        parcel.writeString(athletes)
        parcel.writeString(pregnantWomen)
        parcel.writeString(children)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HealthRecommendations> {
        override fun createFromParcel(parcel: Parcel): HealthRecommendations {
            return HealthRecommendations(parcel)
        }

        override fun newArray(size: Int): Array<HealthRecommendations?> {
            return arrayOfNulls(size)
        }
    }
}
