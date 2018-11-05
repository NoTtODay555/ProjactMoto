package com.example.napat.myapplication.admin.view.view.job


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.napat.myapplication.R
import com.example.napat.myapplication.admin.view.presenter.GetFmAdmin
import com.example.napat.myapplication.admin.view.presenter.GetlistErrorData
import com.example.napat.myapplication.admin.view.presenter.PresenterAdmin
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.admin.view.view.allError.ViewAdmin
import com.example.napat.myapplication.admin.view.view.workerSec.DetailWorkerAdminList
import com.example.napat.myapplication.admin.view.view.workerSec.RecycleAdminWorkers
import com.example.napat.myapplication.database.All
import com.example.napat.myapplication.database.Errors
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.fragment_job_main_adin.*
import kotlinx.android.synthetic.main.fragment_main_admin.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 *
 */
class JobMainAdin(val worker: HomeAdmin) : Fragment() , ViewAdmin {


    private val fireBaseAuth = FirebaseAuth.getInstance()!!
    private val databaseReference = FirebaseDatabase.getInstance().reference
    val getFmWorker : PresenterAdmin = GetFmAdmin(worker)
    val callListError : PresenterAdmin.List = GetlistErrorData(this)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        callListError.getDataAdminError(databaseReference,fireBaseAuth)
        return inflater.inflate(R.layout.fragment_job_main_adin, container, false)
    }
    override fun listDataError(list: Errors) {
        val recyclableAdapter  = list.let { RecycleJob(worker, it) }
        rv_job?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclableAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        worker.setSupportActionBar(toolbar)
        worker.supportActionBar?.setDisplayShowTitleEnabled(false)
        tv_toolbar_title.text = "Job"
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(worker: HomeAdmin): JobMainAdin = JobMainAdin(worker)
    }


}
