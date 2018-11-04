package com.example.napat.myapplication.worker.view.main

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.napat.myapplication.castomer.constuer.Contact
import com.example.napat.myapplication.castomer.constuer.GetFMWorker
import com.example.napat.myapplication.database.All
import com.example.napat.myapplication.worker.view.HomeWorker

class ViewHolder(val view: View, val worker: HomeWorker): RecyclerView.ViewHolder(view)  {
    private var getFM : Contact = GetFMWorker(worker)
    fun onBindData(list : All) {
            view.setOnClickListener {
                val test = ListDetail.newInstance(list,worker)
                getFM.openFragment(test)
        }
    }
}