package com.example.napat.myapplication.castomer.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.napat.myapplication.Login.view.Login
import com.example.napat.myapplication.R
import com.example.napat.myapplication.castomer.constuer.Conteck
import com.example.napat.myapplication.castomer.constuer.GetFM
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_home_customter.*
import kotlinx.android.synthetic.main.activity_home_worker.*

class HomeCustomer : AppCompatActivity() {
    private val getFM : Conteck = GetFM(this)
    private val fireBaseAuth = FirebaseAuth.getInstance()!!
    private val user = fireBaseAuth.currentUser
    private val databaseReference = FirebaseDatabase.getInstance().reference
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home_customer -> {
//                message.setText(R.string.title_home)
                this.finish()
                this.startActivity(Intent(this, HomeCustomersButton:: class.java))
                return@OnNavigationItemSelectedListener true
            }


            R.id.navigation_serview_customer -> {
//                message.setText(R.string.title_notifications)
                val test = Page.newInstance(this)
                getFM.openFragment(test)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_logout_customer -> {
//                message.setText(R.string.title_notifications)
                fireBaseAuth.signOut()
                this.startActivity(Intent(this, Login::class.java))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_customter)
        navigation_customers.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val test = Page.newInstance(this)
        getFM.openFragment(test)
    }

}
