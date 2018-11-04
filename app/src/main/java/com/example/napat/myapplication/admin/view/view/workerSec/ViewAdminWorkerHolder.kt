package com.example.napat.myapplication.admin.view.view.workerSec

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.napat.myapplication.admin.view.presenter.GetFmAdmin
import com.example.napat.myapplication.admin.view.presenter.PresenterAdmin
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.admin.view.view.allError.DetailAdminlist
import com.example.napat.myapplication.database.All
import kotlinx.android.synthetic.main.card_list.view.*
import kotlinx.android.synthetic.main.crad_id_worker.view.*

class ViewAdminWorkerHolder (val view: View, val worker: HomeAdmin): RecyclerView.ViewHolder(view) {
    val getFmAdmin: PresenterAdmin = GetFmAdmin(worker)
    fun onBindData(list: All) {
        view.name_worker.text = list.username
        view.edit_profile.setOnClickListener {
            val test = DetailAdminlist.newInstance(list, worker)
            getFmAdmin.openFragment(test)
        }
        view.history_worker.setOnClickListener {

        }
    }
}