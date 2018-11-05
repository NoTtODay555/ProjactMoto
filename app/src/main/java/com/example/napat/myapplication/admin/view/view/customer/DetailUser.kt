package com.example.napat.myapplication.admin.view.view.customer


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.napat.myapplication.R
import com.example.napat.myapplication.admin.view.presenter.GetFmAdmin
import com.example.napat.myapplication.admin.view.presenter.PresenterAdmin
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.admin.view.view.job.DetailJobForAddmin
import com.example.napat.myapplication.database.All
import com.example.napat.myapplication.database.UserInformation
import kotlinx.android.synthetic.main.fragment_detail_user.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 *
 */
class DetailUser (var worker: HomeAdmin, var list : UserInformation): Fragment() {
    val getFmWorker : PresenterAdmin = GetFmAdmin(worker)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_name_user_admin.text = list.name
        tv_tell_profile_user_admin.text = list.address
        tv_address_profile_user_admin.text = list.address
        tv_gender_profile_user_admin.text = "Female"
        back.setOnClickListener {
            val test = customerProfile.newInstance(worker)
            getFmWorker.openFragment(test)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(worker: HomeAdmin, list : UserInformation): DetailUser = DetailUser(worker,list)
    }

}
