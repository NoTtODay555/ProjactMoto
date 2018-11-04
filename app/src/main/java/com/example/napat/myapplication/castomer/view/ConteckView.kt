package com.example.napat.myapplication.castomer.view

import com.example.napat.myapplication.database.Errors
import com.example.napat.myapplication.database.UserInformation

interface ConteckView {
    interface User{
        fun getlistUser(list : UserInformation,lists : Errors)
    }

}