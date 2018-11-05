package com.example.napat.myapplication.admin.view.view.customer


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.napat.myapplication.R
import com.example.napat.myapplication.admin.view.presenter.GetDataUserAll
import com.example.napat.myapplication.admin.view.presenter.GetFmAdmin
import com.example.napat.myapplication.admin.view.presenter.GetlistErrorData
import com.example.napat.myapplication.admin.view.presenter.PresenterAdmin
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.admin.view.view.allError.ViewAdmin
import com.example.napat.myapplication.admin.view.view.editProfile.EditProfileWorker
import com.example.napat.myapplication.admin.view.view.job.RecycleJob
import com.example.napat.myapplication.database.All
import com.example.napat.myapplication.database.UserInformationAll
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.fragment_job_main_adin.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 *
 */
class customerProfile(val main : HomeAdmin) : Fragment(), ViewAdmin.listUser {
    private val fireBaseAuth = FirebaseAuth.getInstance()!!
    private val databaseReference = FirebaseDatabase.getInstance().reference
    val callListError : PresenterAdmin.ListUser = GetDataUserAll(this)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        callListError.getDataUserAll(databaseReference,fireBaseAuth)
        return inflater.inflate(R.layout.fragment_customer_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        main.setSupportActionBar(toolbar)
        main.supportActionBar?.setDisplayShowTitleEnabled(false)
        tv_toolbar_title.text = "Customer"
    }

    companion object {
        fun newInstance(main : HomeAdmin): customerProfile = customerProfile(main)
    }
    override fun listDataUser(list: UserInformationAll) {
        val recyclableAdapter  = list.let { Recyclecustomer(main, it) }
        rv_job?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclableAdapter
        }
    }



}
