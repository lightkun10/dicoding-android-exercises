package com.dicoding.picodiploma.panduintentappkotlin

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/*
* Parcelable adalah suatu interface yang memungkinkan kita melakukan
* pengiriman objek dari suatu activity ke activity lain.
* Obyek yang di implementasikan dengan parcelable akan memudahkan Anda dalam
* mengiriman data dari satu activity ke activity lainnya.
* */

@Parcelize
data class Person(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable