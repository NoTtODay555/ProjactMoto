package com.example.napat.myapplication.admin.view.view

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.napat.myapplication.R
import com.example.napat.myapplication.admin.view.presenter.GetFmAdmin
import com.example.napat.myapplication.admin.view.presenter.PresenterAdmin
import com.example.napat.myapplication.admin.view.view.allError.ListWorkAdmins
import com.example.napat.myapplication.admin.view.view.workerSec.MainAdmin
import kotlinx.android.synthetic.main.activity_home_admin.*

class HomeAdmin : AppCompatActivity() {

    private val getFM : PresenterAdmin = GetFmAdmin(this)
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home_admin -> {
                val list = ListWorkAdmins.newInstance(this)
                getFM.openFragment(list)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_worker_admin -> {
                val list = MainAdmin.newInstance(this)
                getFM.openFragment(list)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_status_admin -> {
                val list = ListWorkAdmins.newInstance(this)
                getFM.openFragment(list)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_admin)
        val list = ListWorkAdmins.newInstance(this)
        getFM.openFragment(list)
        navigation_admin.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
