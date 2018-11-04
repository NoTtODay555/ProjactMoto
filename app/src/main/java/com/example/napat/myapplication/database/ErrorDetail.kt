package com.example.napat.myapplication.database


data class Errors(
    val listAll: ArrayList<All> = arrayListOf()
)


data class All(
        val longitude: Double = 0.0,
        val proplams: String = "",
        val ratitude: Double= 0.0,
        val tel: String = "",
        val uid: String = "",
        val username: String = ""
)
