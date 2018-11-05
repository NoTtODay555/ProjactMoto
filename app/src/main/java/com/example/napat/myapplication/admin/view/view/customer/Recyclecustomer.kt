package com.example.napat.myapplication.admin.view.view.customer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.napat.myapplication.R
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.admin.view.view.job.ViewJobHolder
import com.example.napat.myapplication.database.Errors
import com.example.napat.myapplication.database.UserInformation
import com.example.napat.myapplication.database.UserInformationAll

class Recyclecustomer(val worker: HomeAdmin, private var errors: UserInformationAll): RecyclerView.Adapter<ViewUserHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewUserHolder {
        return ViewUserHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_job_list, parent, false), worker)
    }

    override fun getItemCount(): Int {
        return errors.listAll.size
    }

    override fun onBindViewHolder(holder: ViewUserHolder, position: Int) {
        return errors?.listAll?.get(position)?.let { holder.onBindData(it) }!!
    }
}