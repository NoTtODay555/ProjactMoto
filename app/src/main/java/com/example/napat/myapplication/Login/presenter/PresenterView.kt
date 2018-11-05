package com.example.napat.myapplication.Login.presenter

import com.example.napat.myapplication.Login.view.Login
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference

interface PresenterView  {
    interface UserLogin{
        fun userLogin(context: Login, fireBaseAuth : FirebaseAuth, databaseReference : DatabaseReference, user: FirebaseUser?)
        fun userclass(classs : String,fireBaseAuth : FirebaseAuth, databaseReference : DatabaseReference, user: FirebaseUser? )
    }

}