package com.example.napat.myapplication.castomer.constuer

import android.support.v4.app.Fragment
import com.example.napat.myapplication.R
import com.example.napat.myapplication.castomer.view.HomeCustomer

class GetFM(val main : HomeCustomer) : Conteck{
    override fun openFragment(fragment: Fragment) {
        val transaction = main.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.homeCustomer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}