package com.example.napat.myapplication.worker.constuer

import android.util.Log
import com.example.napat.myapplication.castomer.constuer.Contact
import com.example.napat.myapplication.database.*
import com.example.napat.myapplication.worker.view.workConstuView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import java.lang.Error
import com.google.gson.reflect.TypeToken

class CallError(val page : workConstuView) : Contact.List{
    override fun getDataError(databaseReference: DatabaseReference, fireBaseAuth : FirebaseAuth)  {
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