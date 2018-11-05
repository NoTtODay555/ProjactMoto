package com.example.napat.myapplication.admin.view.view.job

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.napat.myapplication.admin.view.presenter.GetFmAdmin
import com.example.napat.myapplication.admin.view.presenter.PresenterAdmin
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.admin.view.view.editProfile.EditProfileWorker
import com.example.napat.myapplication.admin.view.view.historyworker.AdminHistoryWorker
import com.example.napat.myapplication.database.All
import kotlinx.android.synthetic.main.card_job_list.view.*
import kotlinx.android.synthetic.main.crad_id_worker.view.*

class ViewJobHolder (val view: View, val worker: HomeAdmin): RecyclerView.ViewHolder(view) {
    val getFmAdmin: PresenterAdmin = GetFmAdmin(worker)
    @SuppressLint("SetTextI18n")
    fun onBindData(list: All) {
        val x = "" + list.proplams + " : " + list.username
        view?.tv_job_id?.text = x
        view?.cv_job?.setOnClickListener {
            val test = DetailJobForAddmin.newInstance(worker,list)
            getFmAdmin.openFragment(test)
        }
    }
}
