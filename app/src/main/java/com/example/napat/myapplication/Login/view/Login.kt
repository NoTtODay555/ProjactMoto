@file:Suppress("DEPRECATION")

package com.example.napat.myapplication.Login.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import com.example.napat.myapplication.R
import com.example.napat.myapplication.Login.presenter.PresenterView
import com.example.napat.myapplication.Login.presenter.UserLogin
import com.example.napat.myapplication.R.id.test
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.castomer.view.HomeCustomer
import com.example.napat.myapplication.castomer.view.HomeCustomersButton
import com.example.napat.myapplication.database.History
import com.example.napat.myapplication.database.UserInformation
import com.example.napat.myapplication.worker.view.HomeWorker
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*
import kotlin.collections.ArrayList

@Suppress("DEPRECATION")
class Login : AppCompatActivity()
        ,View.OnClickListener
        , ViewInterface.Login {
    private val fireBaseAuth = FirebaseAuth.getInstance()!!
    private val user = fireBaseAuth.currentUser
    private val databaseReference = FirebaseDatabase.getInstance().reference
    private val userlogin : PresenterView.UserLogin = UserLogin(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val y : ArrayList<History> = arrayListOf()
        val x = Date(2015,2,1)
        val testHistory = History(x,"test",2.5)
        y.add(testHistory)
        y.add(testHistory)
        y.add(testHistory)
        y.add(testHistory)
        val test = UserInformation("test","test","test","customer",y)
        Log.e("test",test.toString())
        if(fireBaseAuth.currentUser != null){
            fireBaseAuth.signOut()
        }
        supportActionBar?.hide()


        buttonSignupLogin.setOnClickListener(this@Login)
        register.setOnClickListener(this@Login)
    }

    override fun onClick(v: View?) {
        if(v == buttonSignupLogin){
            userlogin.userLogin(this,fireBaseAuth,databaseReference,user)

        }
        if(v == register){
            finish()
            this.startActivity(Intent(this, Register:: class.java))
        }
    }
    override fun onSuccessful(number: Int) {
        when(number){
            1 -> {
                Toast.makeText(this,"Successfully SignIn", Toast.LENGTH_SHORT).show()
                this.finish()
                this.startActivity(Intent(this, HomeCustomersButton:: class.java))
            }
            2 -> {
                this.finish()
                this.startActivity(Intent(this, HomeWorker:: class.java))
                Toast.makeText(this,"Successfully worker", Toast.LENGTH_SHORT).show()

            }
            3 -> {
                this.finish()
                this.startActivity(Intent(this, HomeAdmin:: class.java))
                Toast.makeText(this,"Successfully Admin", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(this,"Registration Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
