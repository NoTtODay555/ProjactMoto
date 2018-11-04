package com.example.napat.myapplication.Login.constucter

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference

interface PresenterIF {
    interface GetClass{
        fun initSaladMenu(databaseReference: DatabaseReference,fireBaseAuth : FirebaseAuth)
    }
}