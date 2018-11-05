package com.example.napat.myapplication.database

import android.os.Parcel
import android.os.Parcelable
import com.example.napat.myapplication.castomer.view.ConteckView
import java.util.*

data class UserInformationAll(
        val listAll: ArrayList<UserInformation> = arrayListOf()
)
data class UserInformation (
    val name : String? = "",
    val address : String? = "",
    val position : String? = "",
    val levels : String? = "",
    val test: ArrayList<History> = arrayListOf()
)

data class History(
    val date : Date? = null,
    val problem : String? = "",
    val rate : Double? = 0.0
)