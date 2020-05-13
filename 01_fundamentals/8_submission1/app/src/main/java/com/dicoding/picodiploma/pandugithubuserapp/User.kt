package com.dicoding.picodiploma.pandugithubuserapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var avatar: Int?,
    var username: String?,
    var name: String?,
    var location: String?,
    var repository: Int?,
    var company: String?,
    var followers: Int?,
    var following: Int?
) : Parcelable