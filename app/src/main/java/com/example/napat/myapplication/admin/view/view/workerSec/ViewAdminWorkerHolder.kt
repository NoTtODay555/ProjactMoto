package com.example.napat.myapplication.admin.view.view.workerSec

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.napat.myapplication.admin.view.presenter.GetFmAdmin
import com.example.napat.myapplication.admin.view.presenter.PresenterAdmin
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.admin.view.view.allError.DetailAdminlist
import com.example.napat.myapplication.admin.view.view.editProfile.EditProfileWorker
import com.example.napat.myapplication.admin.view.view.historyworker.AdminHistoryWorker
import com.example.napat.myapplication.database.All
import com.example.napat.myapplication.worker.view.history.Historys
import kotlinx.android.synthetic.main.card_list.view.*
import kotlinx.android.synthetic.main.crad_id_worker.view.*

class ViewAdminWorkerHolder (val view: View, val worker: HomeAdmin): RecyclerView.ViewHolder(view) {
    val getFmAdmin: PresenterAdmin = GetFmAdmin(worker)
    fun onBindData(list: All) {
        view.name_worker.text = list.username
        view.edit_profile.setOnClickListener {
            val test = EditProfileWorker.newInstance(worker,list)
            getFmAdmin.openFragment(test)
        }
        view.history_worker.setOnClickListener {
            val test = AdminHistoryWorker.newInstance(worker)
            getFmAdmin.openFragment(test)
        }
    }
}