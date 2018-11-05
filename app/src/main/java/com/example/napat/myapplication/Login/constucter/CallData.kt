package com.example.napat.myapplication.Login.constucter

import android.util.Log
import com.example.napat.myapplication.database.UserInformation
import com.example.napat.myapplication.Login.presenter.PresenterView
import com.example.napat.myapplication.Login.presenter.UserLogin
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class CallData(var userlogin : PresenterView.UserLogin) : PresenterIF.GetClass {
    override fun initSaladMenu(databaseReference: DatabaseReference,fireBaseAuth : FirebaseAuth)  {
        Log.e("initSaladMenu" , "Success")
        val user  = fireBaseAuth.currentUser!!
        val proflieListener = object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Error ", "loadPost:onCancelled ${databaseError.toException()}")
            }
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val proflie = dataSnapshot.getValue(UserInformation::class.java)
                    Log.e("test",proflie.toString())
                    proflie!!.levels?.let { userlogin.userclass(it,fireBaseAuth,databaseReference,user) }
                }
            }
        }
        user.uid.let { databaseReference.child("user").child(it).addListenerForSingleValueEvent(proflieListener) }
    }

}