package com.example.napat.myapplication.admin.view.view.workerSec

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.napat.myapplication.R
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.admin.view.view.allError.ViewAdminHolder
import com.example.napat.myapplication.database.Errors

class RecycleAdminWorker (val worker: HomeAdmin, private var error: Errors?): RecyclerView.Adapter<ViewAdminWorkerHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAdminWorkerHolder {
        return ViewAdminWorkerHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_list, parent, false), worker)
    }

    override fun getItemCount(): Int {
        return  error?.listAll?.size!!
    }

    override fun onBindViewHolder(holder: ViewAdminWorkerHolder, position: Int) {
        return error?.listAll?.get(position)?.let { holder.onBindData(it) }!!
    }
}