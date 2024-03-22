package com.example.solutionx.model

import android.os.Parcel
import android.os.Parcelable

data class Color(
    val red: Int,
    val green: Int,
    val blue: Int,
    val alpha: Int?,

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.createStringArrayList()!!
    )

    constructor(
        readInt: Int,
        readInt1: Int,
        i3: Int?,
        createStringArrayList: ArrayList<String>
    ) : this(0, 0, 0, 0)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(red)
        parcel.writeInt(green)
        parcel.writeInt(blue)
        parcel.writeValue(alpha)
        parcel.writeStringList()
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Color> {
        override fun createFromParcel(parcel: Parcel): Color {
            return Color(parcel)
        }

        override fun newArray(size: Int): Array<Color?> {
            return arrayOfNulls(size)
        }
    }

}

private fun Parcel.writeStringList() {
    return writeStringList(emptyList())
}
