package com.example.napat.myapplication.admin.view.presenter

import android.support.v4.app.Fragment
import com.example.napat.myapplication.R
import com.example.napat.myapplication.admin.view.view.HomeAdmin

class GetFmAdmin(val main : HomeAdmin) : PresenterAdmin {
    override fun openFragment(fragment: Fragment) {
        val transaction = main.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.homeAdmin, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}