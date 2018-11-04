package com.example.napat.myapplication.admin.view.view.allError


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
import com.example.napat.myapplication.database.All
import kotlinx.android.synthetic.main.fragment_list_detail.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 *
 */
class DetailAdminlist(val list : All,val worker: HomeAdmin) : Fragment() {

    val getFmAdmin : PresenterAdmin = GetFmAdmin(worker)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_adminlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_id.text = list.username
        tv_problem.text = list.proplams
        tv_tell.text = list.tel
        bt_return.setOnClickListener {
            val list = ListWorkAdmins.newInstance(worker)
            getFmAdmin.openFragment(list)
        }
        super.onViewCreated(view, savedInstanceState)
    }
    companion object {
        fun newInstance(list : All, worker: HomeAdmin): DetailAdminlist = DetailAdminlist(list, worker)
    }


}
