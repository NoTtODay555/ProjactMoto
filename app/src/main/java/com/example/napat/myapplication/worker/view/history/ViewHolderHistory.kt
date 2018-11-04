package com.example.napat.myapplication.worker.view.history

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.napat.myapplication.R.id.date
import com.example.napat.myapplication.castomer.constuer.Contact
import com.example.napat.myapplication.castomer.constuer.GetFMWorker
import com.example.napat.myapplication.database.All
import com.example.napat.myapplication.database.History
import com.example.napat.myapplication.worker.view.HomeWorker
import com.example.napat.myapplication.worker.view.main.ListDetail
import kotlinx.android.synthetic.main.cradhistory.view.*

class ViewHolderHistory(val view: View, val worker: HomeWorker): RecyclerView.ViewHolder(view) {
    fun onBindData(list : History) {
        view.date.text = list.date.toString()
        view.work.text = list.problem.toString()
        view.rateing.text = list.rate.toString()
    }
}
