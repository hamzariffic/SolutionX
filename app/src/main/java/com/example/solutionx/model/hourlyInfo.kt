package com.example.solutionx.model

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

data class HourlyInfo(
    val dateTime: String?,
    val indexes: ArrayList<Index>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createTypedArrayList(Index)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(dateTime)
        parcel.writeTypedList(indexes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HourlyInfo> {
        override fun createFromParcel(parcel: Parcel): HourlyInfo {
            return HourlyInfo(parcel)
        }

        override fun newArray(size: Int): Array<HourlyInfo?> {
            return arrayOfNulls(size)
        }
    }
}
