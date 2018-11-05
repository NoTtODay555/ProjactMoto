package com.example.napat.myapplication.admin.view.view.historyworker

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.database.History
import com.example.napat.myapplication.worker.view.HomeWorker
import kotlinx.android.synthetic.main.cradhistory.view.*

class ViewHolderHistoryUser(val view: View, val worker: HomeAdmin): RecyclerView.ViewHolder(view) {
    fun onBindData(list : History) {
        view.date.text = list.date.toString()
        view.work.text = list.problem.toString()
        view.rateing.text = list.rate.toString()
    }
}
