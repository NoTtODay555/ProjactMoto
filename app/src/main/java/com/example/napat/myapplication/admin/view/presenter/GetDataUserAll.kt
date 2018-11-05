package com.example.napat.myapplication.admin.view.presenter

import android.support.v4.app.Fragment
import android.util.Log
import com.example.napat.myapplication.admin.view.view.allError.ViewAdmin
import com.example.napat.myapplication.admin.view.view.customer.customerProfile
import com.example.napat.myapplication.database.Errors
import com.example.napat.myapplication.database.UserInformationAll
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class GetDataUserAll(val page : customerProfile) : PresenterAdmin.ListUser {
    override fun getDataUserAll(databaseReference: DatabaseReference, fireBaseAuth: FirebaseAuth) {

        val proflieListener = object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Error ", "loadPost:onCancelled ${databaseError.toException()}")
            }
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {

                    val test = dataSnapshot.getValue(UserInformationAll::class.java)
                    test?.let { page.listDataUser(it) }
                }

            }
        }
        databaseReference.child("user").addListenerForSingleValueEvent(proflieListener)
    }

}