package com.example.napat.myapplication.admin.view.presenter

import android.util.Log
import com.example.napat.myapplication.admin.view.view.allError.ViewAdmin
import com.example.napat.myapplication.database.Errors
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class GetlistErrorData(val page : ViewAdmin) : PresenterAdmin.List {
    override fun getDataAdminError(databaseReference: DatabaseReference, fireBaseAuth: FirebaseAuth) {
            Log.e("CallError" , "Success")
            val proflieListener = object : ValueEventListener {
                override fun onCancelled(databaseError: DatabaseError) {
                    Log.e("Error ", "loadPost:onCancelled ${databaseError.toException()}")
                }
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        Log.e("scce ", dataSnapshot.toString())
                        Log.e("test",dataSnapshot.getValue(Errors::class.java)!!.toString())
                        val test = dataSnapshot.getValue(Errors::class.java)
                        test?.let { page.listDataError(it) }
                    }

                }
            }
            databaseReference.child("error").addListenerForSingleValueEvent(proflieListener)
    }
}