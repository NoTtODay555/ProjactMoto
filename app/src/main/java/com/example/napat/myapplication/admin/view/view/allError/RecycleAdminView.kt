package com.example.napat.myapplication.admin.view.view.allError

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.napat.myapplication.R
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.database.Errors

class RecycleAdminView(val worker: HomeAdmin, private var error: Errors?): RecyclerView.Adapter<ViewAdminHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAdminHolder {
        return ViewAdminHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_list, parent, false), worker)

    }

    override fun getItemCount(): Int {
        Log.e("error size" , (error?.listAll?.size.toString()))
        return  error?.listAll?.size!!
    }

    override fun onBindViewHolder(holder: ViewAdminHolder, position: Int) {
        return error?.listAll?.get(position)?.let { holder.onBindData(it) }!!
    }
}