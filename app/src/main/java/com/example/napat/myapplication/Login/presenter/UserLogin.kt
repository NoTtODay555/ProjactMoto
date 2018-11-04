package com.example.napat.myapplication.Login.presenter

import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.napat.myapplication.Login.constucter.CallData
import com.example.napat.myapplication.Login.constucter.PresenterIF
import com.example.napat.myapplication.Login.view.Login
import com.example.napat.myapplication.Login.view.ViewInterface
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_login.*

class UserLogin ( private val login : ViewInterface.Login ): PresenterView.UserLogin {

    private  val callData : PresenterIF.GetClass = CallData(this)
    override fun userLogin(context: Login, fireBaseAuth : FirebaseAuth, databaseReference : DatabaseReference, user: FirebaseUser?){
        val email = context.editTextEmailLogin?.text.toString().trim()
        val password = context.editTextPasswordLogin?.text.toString().trim()
        Log.e("userLogin" , "Success")

        if(TextUtils.isEmpty(email)){
            Toast.makeText(context,"Please enter email", Toast.LENGTH_LONG).show()
            return
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(context,"Please enter password", Toast.LENGTH_LONG).show()
            return
        }

        fireBaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(context){
            if (it.isSuccessful) {
                Toast.makeText(context,"Wait ...", Toast.LENGTH_LONG).show()
                callData.initSaladMenu(databaseReference,fireBaseAuth)
            } else {
                login.onSuccessful(5)
            }
        }

    }
    override fun userclass(classs: String) {
        when (classs) {
            "Customer" -> login.onSuccessful(1)
            "worker" -> login.onSuccessful(2)
            "admin" -> login.onSuccessful(3)
            else -> login.onSuccessful(10)
        }
    }
}