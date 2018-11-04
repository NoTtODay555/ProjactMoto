package com.example.napat.myapplication.castomer.constuer

import android.support.v4.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

interface Contact {
        fun openFragment(fragment: Fragment)
        interface List{
                fun getDataError(databaseReference: DatabaseReference, fireBaseAuth : FirebaseAuth)
        }
}