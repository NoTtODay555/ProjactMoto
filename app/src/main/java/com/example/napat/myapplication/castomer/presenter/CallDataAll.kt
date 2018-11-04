package com.example.napat.myapplication.castomer.presenter

import android.util.Log
import com.example.napat.myapplication.castomer.constuer.Conteck
import com.example.napat.myapplication.database.Errors
import com.example.napat.myapplication.database.UserInformation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class CallDataAll(val data : Conteck.Data) : ContentPre{
    override fun  dataUser(databaseReference: DatabaseReference, fireBaseAuth : FirebaseAuth)  {
        Log.e("initSaladMenu" , "Success")
        var x : UserInformation? = null
        var y : Errors? = null
        val user  = fireBaseAuth.currentUser!!
        val proflieListener = object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Error ", "loadPost:onCancelled ${databaseError.toException()}")
            }
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val proflie = dataSnapshot.getValue(UserInformation::class.java)
                    Log.e("test",proflie.toString())
                    x = proflie
                }
            }
        }
        val proflieListener1 = object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Error ", "loadPost:onCancelled ${databaseError.toException()}")
            }
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    Log.e("scce ", dataSnapshot.toString())
                    Log.e("test",dataSnapshot.getValue(Errors::class.java)!!.toString())
                    val test = dataSnapshot.getValue(Errors::class.java)
                    y = test
                    x?.let { test?.let { it1 -> data.dataUser(it, it1) } }
                }

            }
        }

        user.uid.let { databaseReference.child("user").child(it).addListenerForSingleValueEvent(proflieListener) }
        Log.e("e",x.toString())
        databaseReference.child("error").addListenerForSingleValueEvent(proflieListener1)

    }
}