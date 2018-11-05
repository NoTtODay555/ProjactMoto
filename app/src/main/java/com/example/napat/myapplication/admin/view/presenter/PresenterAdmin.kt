package com.example.napat.myapplication.admin.view.presenter

import android.support.v4.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

interface PresenterAdmin {
    fun openFragment(fragment: Fragment)
    interface List{
        fun getDataAdminError(databaseReference: DatabaseReference, fireBaseAuth : FirebaseAuth)
    }
    interface ListUser{
        fun getDataUserAll(databaseReference: DatabaseReference, fireBaseAuth : FirebaseAuth)
    }
}