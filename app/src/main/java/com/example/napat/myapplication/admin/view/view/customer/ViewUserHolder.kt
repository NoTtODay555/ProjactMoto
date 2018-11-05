package com.example.napat.myapplication.admin.view.view.customer

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.napat.myapplication.admin.view.presenter.GetFmAdmin
import com.example.napat.myapplication.admin.view.presenter.PresenterAdmin
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.admin.view.view.job.DetailJobForAddmin
import com.example.napat.myapplication.database.All
import com.example.napat.myapplication.database.UserInformation
import com.example.napat.myapplication.database.UserInformationAll
import kotlinx.android.synthetic.main.card_job_list.view.*

class ViewUserHolder(val view: View, val worker: HomeAdmin): RecyclerView.ViewHolder(view)  {
    val getFmAdmin: PresenterAdmin = GetFmAdmin(worker)
    @SuppressLint("SetTextI18n")
    fun onBindData(list: UserInformation) {
        val x = "ID :" + list.name
        view?.tv_job_id?.text = x
        view?.cv_job?.setOnClickListener {
            val test = DetailUser.newInstance(worker,list)
            getFmAdmin.openFragment(test)
        }
    }
}
