package com.example.panduintentapp

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable

/* Using parcelize to implement parcelable. 

Person class will be used in MoveWithObjectActivity. */