package com.codeenemy.models

import android.os.Parcel
import android.os.Parcelable

data class PowerData(
    val date: String,
    val time: String,
    val globalActivePower: String,
    val globalReactivePower: String,
    val voltage: String,
    val globalIntensity: String,
    val subMetering1: String,
    val subMetering2: String,
    val subMetering3: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(date)
        parcel.writeString(time)
        parcel.writeString(globalActivePower)
        parcel.writeString(globalReactivePower)
        parcel.writeString(voltage)
        parcel.writeString(globalIntensity)
        parcel.writeString(subMetering1)
        parcel.writeString(subMetering2)
        parcel.writeString(subMetering3)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PowerData> {
        override fun createFromParcel(parcel: Parcel): PowerData {
            return PowerData(parcel)
        }

        override fun newArray(size: Int): Array<PowerData?> {
            return arrayOfNulls(size)
        }
    }
}
