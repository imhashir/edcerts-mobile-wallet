package com.that.edcerts.models

import android.os.Parcel
import android.os.Parcelable

class Certificate(name: String) : Parcelable {

    var certificateName: String = ""

    constructor(parcel: Parcel) : this(parcel.readString()) {
        certificateName = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(certificateName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Certificate> {
        override fun createFromParcel(parcel: Parcel): Certificate {
            return Certificate(parcel)
        }

        override fun newArray(size: Int): Array<Certificate?> {
            return arrayOfNulls(size)
        }
    }

}