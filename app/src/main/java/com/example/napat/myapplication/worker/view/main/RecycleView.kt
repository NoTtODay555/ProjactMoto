package com.example.napat.myapplication.worker.view.main

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.napat.myapplication.R
import com.example.napat.myapplication.database.Errors
import com.example.napat.myapplication.worker.view.HomeWorker

class RecycleView(val worker: HomeWorker, private var error: Errors?): RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_list, parent, false), worker)

    }

    override fun getItemCount(): Int {
        Log.e("error size" , (error?.listAll?.size.toString()))
        return  error?.listAll?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return error?.listAll?.get(position)?.let { holder.onBindData(it) }!!
    }
}