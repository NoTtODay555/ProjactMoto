package com.example.napat.myapplication.Login.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import android.view.View
import android.app.ProgressDialog
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import com.example.napat.myapplication.R
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_login.*


@Suppress("DEPRECATION")
class Register : AppCompatActivity(),View.OnClickListener {
    override fun onClick(v: View?) {
        registerUser()
    }

    private val fireBaseAuth = FirebaseAuth.getInstance()
     private val progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(fireBaseAuth.currentUser != null){
            finish()
            this.startActivity(Intent(this, ProfileActivity:: class.java))
        }
        this.buttonSignup.setOnClickListener(this@Register)

    }

    private fun registerUser() {
        val email = editTextEmail?.text.toString().trim()
        val password = editTextPassword?.text.toString().trim()

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show()
            return
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show()
            return
        }


        progressDialog?.setMessage("Registering Please Wait...")
        progressDialog?.show()

        fireBaseAuth?.createUserWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this) { task ->
                    //checking if success
                    if (task.isSuccessful) {
                        Log.e("Checkcreate", "isSuccessful")
                        Toast.makeText(this@Register,"Successfully registered",Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@Register,"Registration Error",Toast.LENGTH_SHORT).show()
                    }
                    progressDialog?.dismiss()
                }
        fireBaseAuth.signInWithEmailAndPassword(email , password).addOnCompleteListener(this){
            if (it.isSuccessful) {
                Log.e("CheckSingin", "isSuccessful")
                finish()
                startActivity(this.intent.putExtra("test1", ProfileActivity::class.java))
            } else {
                Toast.makeText(this,"Login Error",Toast.LENGTH_LONG).show()
            }
        }
    }

}
