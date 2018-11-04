package com.example.napat.myapplication.worker.view.main


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.napat.myapplication.R
import com.example.napat.myapplication.castomer.constuer.Contact
import com.example.napat.myapplication.castomer.constuer.GetFMWorker
import com.example.napat.myapplication.database.All
import com.example.napat.myapplication.worker.view.HomeWorker
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.fragment_list_detail.*
import kotlinx.android.synthetic.main.fragment_page.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 *
 */
class ListDetail(private val list : All, val worker: HomeWorker) : Fragment() {
    private var getFM : Contact = GetFMWorker(worker)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_id.text = list.username
        tv_problem.text = list.proplams
        tv_tell.text = list.tel
//        bt_return.setOnClickListener {
//            val list = ListWork.newInstance(worker)
//            getFM.openFragment(list)
//        }
        worker.setSupportActionBar(toolbar)
        worker.supportActionBar?.setDisplayShowTitleEnabled(false)
        tv_toolbar_title.text = "Job"
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(list : All,worker: HomeWorker): ListDetail = ListDetail(list, worker)
    }


}
