package com.example.napat.myapplication.worker.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.napat.myapplication.Login.view.Login
import com.example.napat.myapplication.R
import com.example.napat.myapplication.castomer.constuer.Contact
import com.example.napat.myapplication.castomer.constuer.GetFMWorker
import com.example.napat.myapplication.database.All
import com.example.napat.myapplication.worker.view.history.Historys
import com.example.napat.myapplication.worker.view.main.ListDetail
import com.example.napat.myapplication.worker.view.main.ListWork
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_home_worker.*

class HomeWorker : AppCompatActivity() {

    private val fireBaseAuth = FirebaseAuth.getInstance()!!
    private val user = fireBaseAuth.currentUser
    private val databaseReference = FirebaseDatabase.getInstance().reference
    private var getFM : Contact = GetFMWorker(this)

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_job_worker -> {
                val list = user?.uid?.let { All(0.0,"SOS",0.0,"0999999999", it,"test")
                }?.let { ListDetail.newInstance(it,this) }
                list?.let { getFM.openFragment(it) }
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_history_worker -> {
                val home = Historys.newInstance(this)
                getFM.openFragment(home)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_logout_worker -> {
                fireBaseAuth.signOut()
                this.startActivity(Intent(this, Login::class.java))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_worker)
        val list = user?.uid?.let { All(0.0,"SOS",0.0,"0999999999", it,"test")
        }?.let { ListDetail.newInstance(it,this) }
        list?.let { getFM.openFragment(it) }
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
