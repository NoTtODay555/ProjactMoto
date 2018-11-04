package com.example.napat.myapplication.castomer.constuer

import android.support.v4.app.Fragment
import com.example.napat.myapplication.database.Errors
import com.example.napat.myapplication.database.UserInformation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

interface Conteck {
        fun openFragment(fragment: Fragment)
        interface Data{
                fun dataUser(list : UserInformation,lists : Errors)
                fun getDataUser(databaseReference: DatabaseReference, fireBaseAuth : FirebaseAuth)
        }
}