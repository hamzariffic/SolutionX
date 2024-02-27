package com.example.solutionx.model

import android.os.Parcel
import android.os.Parcelable

// Contains air quality indices
data class Index(
    val code: String?,
    val displayName: String?,
    val aqi: Int,
    val aqiDisplay: String?,
//    val color: com.example.solutionx.model.Color,
    val category: String?,
    val dominantPollutant: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
//        Color("", 0, 0, 0),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(code)
        parcel.writeString(displayName)
        parcel.writeInt(aqi)
        parcel.writeString(aqiDisplay)
        parcel.writeString(category)
        parcel.writeString(dominantPollutant)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Index> {
        override fun createFromParcel(parcel: Parcel): Index {
            return Index(parcel)
        }

        override fun newArray(size: Int): Array<Index?> {
            return arrayOfNulls(size)
        }
    }
}
