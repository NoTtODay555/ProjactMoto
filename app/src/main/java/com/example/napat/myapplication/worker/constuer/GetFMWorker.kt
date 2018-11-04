package com.example.napat.myapplication.castomer.constuer

import android.support.v4.app.Fragment
import com.example.napat.myapplication.R
import com.example.napat.myapplication.worker.view.HomeWorker

class GetFMWorker(val main : HomeWorker) : Contact{
    override fun openFragment(fragment: Fragment) {
        val transaction = main.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.homeWorker, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}