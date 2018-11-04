package com.example.napat.myapplication.admin.view.view.workerSec


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
import com.example.napat.myapplication.admin.view.view.addWorker.WorkerListAdmin
import com.example.napat.myapplication.admin.view.view.allError.ListWorkAdmins
import com.example.napat.myapplication.admin.view.view.allError.RecycleAdminView
import com.example.napat.myapplication.admin.view.view.allError.ViewAdmin
import com.example.napat.myapplication.database.Errors
import com.example.napat.myapplication.worker.view.workConstuView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_list_work.*
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
class MainAdmin(val main : HomeAdmin) : Fragment(),ViewAdmin {
    private val fireBaseAuth = FirebaseAuth.getInstance()!!
    private val databaseReference = FirebaseDatabase.getInstance().reference
    val getFmWorker : PresenterAdmin = GetFmAdmin(main)
    val callListError : PresenterAdmin.List = GetlistErrorData(this)
    override fun listDataError(list: Errors) {
        val recyclableAdapter  = list?.let { RecycleAdminView(main, it) }
        rv_list_admin__worker?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclableAdapter
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        callListError.getDataAdminError(databaseReference,fireBaseAuth)
        return inflater.inflate(R.layout.fragment_main_admin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bt_addWorker.setOnClickListener {
            val add = WorkerListAdmin.newInstance(main)
            getFmWorker.openFragment(add)
        }
    }

    companion object {
        fun newInstance(main : HomeAdmin): MainAdmin = MainAdmin(main)
    }




}
