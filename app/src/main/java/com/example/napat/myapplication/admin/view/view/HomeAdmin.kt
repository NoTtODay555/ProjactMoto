package com.example.napat.myapplication.admin.view.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.napat.myapplication.Login.view.Login
import com.example.napat.myapplication.R
import com.example.napat.myapplication.admin.view.presenter.GetFmAdmin
import com.example.napat.myapplication.admin.view.presenter.PresenterAdmin
import com.example.napat.myapplication.admin.view.view.allError.ListWorkAdmins
import com.example.napat.myapplication.admin.view.view.customer.customerProfile
import com.example.napat.myapplication.admin.view.view.job.JobMainAdin
import com.example.napat.myapplication.admin.view.view.workerSec.MainAdmin
import com.example.napat.myapplication.castomer.constuer.Conteck
import com.example.napat.myapplication.castomer.constuer.GetFM
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_home_admin.*

class HomeAdmin : AppCompatActivity() {
    private val fireBaseAuth = FirebaseAuth.getInstance()!!
    private val user = fireBaseAuth.currentUser
    private val databaseReference = FirebaseDatabase.getInstance().reference
    private val getFM : PresenterAdmin = GetFmAdmin(this)
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home_admin -> {
                val list = JobMainAdin.newInstance(this)
                getFM.openFragment(list)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_worker_admin -> {
                val list = customerProfile.newInstance(this)
                getFM.openFragment(list)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_status_admin -> {
                val list = MainAdmin.newInstance(this)
                getFM.openFragment(list)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_logout_admin -> {
                fireBaseAuth.signOut()
                this.finish()
                this.startActivity(Intent(this, Login::class.java))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_admin)
        navigation_admin.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val list = JobMainAdin.newInstance(this)
        getFM.openFragment(list)
    }
}
