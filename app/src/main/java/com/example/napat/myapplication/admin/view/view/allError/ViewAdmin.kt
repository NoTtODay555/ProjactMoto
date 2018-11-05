package com.example.napat.myapplication.admin.view.view.allError

import com.example.napat.myapplication.database.Errors
import com.example.napat.myapplication.database.UserInformationAll

interface ViewAdmin {
    fun listDataError(list: Errors)
    interface listUser{
        fun listDataUser(list: UserInformationAll)
    }
}