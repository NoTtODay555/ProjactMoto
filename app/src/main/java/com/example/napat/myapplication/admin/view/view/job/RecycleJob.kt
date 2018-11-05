package com.example.napat.myapplication.admin.view.view.job

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.napat.myapplication.R
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.admin.view.view.workerSec.ViewAdminWorkerHolder
import com.example.napat.myapplication.database.Errors

class RecycleJob(val worker: HomeAdmin, private var errors: Errors): RecyclerView.Adapter<ViewJobHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewJobHolder {
        return ViewJobHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_job_list, parent, false), worker)
    }

    override fun getItemCount(): Int {
        return errors.listAll.size
    }

    override fun onBindViewHolder(holder: ViewJobHolder, position: Int) {
        return errors?.listAll?.get(position)?.let { holder.onBindData(it) }!!
    }
}