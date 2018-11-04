package com.example.napat.myapplication.castomer.presenter

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

interface ContentPre {
    fun  dataUser(databaseReference: DatabaseReference, fireBaseAuth : FirebaseAuth)
}