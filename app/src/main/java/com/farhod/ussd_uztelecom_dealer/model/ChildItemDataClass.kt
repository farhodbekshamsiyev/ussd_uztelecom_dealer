package com.farhod.ussd_uztelecom_dealer.model


import android.os.Parcel
import android.os.Parcelable

data class ChildItemDataClass(
    val activate: String?,
    val check: String?,
    val cost: String?,
    val deactivate: String?,
    val desclong: String?,
    val descshort: String?,
    val title: String?,
    val titletype: String?,
    val type: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<ChildItemDataClass> {
        override fun createFromParcel(parcel: Parcel): ChildItemDataClass {
            return ChildItemDataClass(parcel)
        }

        override fun newArray(size: Int): Array<ChildItemDataClass?> {
            return arrayOfNulls(size)
        }
    }
}