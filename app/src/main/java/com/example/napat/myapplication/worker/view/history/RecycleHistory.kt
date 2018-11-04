package com.example.napat.myapplication.worker.view.history

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.napat.myapplication.R
import com.example.napat.myapplication.database.Errors
import com.example.napat.myapplication.database.History
import com.example.napat.myapplication.worker.view.HomeWorker

class RecycleHistory(val worker: HomeWorker, private var history:ArrayList<History>): RecyclerView.Adapter<ViewHolderHistory>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHistory {
        return ViewHolderHistory(LayoutInflater.from(parent.context).inflate(R.layout.cradhistory, parent, false), worker)
    }

    override fun getItemCount(): Int {
        return history.size
    }

    override fun onBindViewHolder(holder: ViewHolderHistory, position: Int) {
        history[position].let { holder.onBindData(it) }
    }
}