package com.example.napat.myapplication.admin.view.view.historyworker

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.napat.myapplication.R
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.admin.view.view.workerSec.ViewAdminWorkerHolder
import com.example.napat.myapplication.database.History
import com.example.napat.myapplication.worker.view.HomeWorker
import com.example.napat.myapplication.worker.view.history.ViewHolderHistory

class RecycleHistoryAdmin(val worker: HomeAdmin, private var history:ArrayList<History>): RecyclerView.Adapter<ViewHolderHistoryUser>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHistoryUser {
        return ViewHolderHistoryUser(LayoutInflater.from(parent.context).inflate(R.layout.crad_id_worker, parent, false), worker)
    }

    override fun getItemCount(): Int {
        return  history.size
    }

    override fun onBindViewHolder(holder: ViewHolderHistoryUser, position: Int) {
        history[position].let { holder.onBindData(it) }
    }
}