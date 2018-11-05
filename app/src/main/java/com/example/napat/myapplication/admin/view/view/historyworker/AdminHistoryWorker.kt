package com.example.napat.myapplication.admin.view.view.historyworker


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.napat.myapplication.R
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.admin.view.view.workerSec.MainAdmin
import com.example.napat.myapplication.database.History
import com.example.napat.myapplication.worker.view.HomeWorker
import com.example.napat.myapplication.worker.view.history.Historys
import com.example.napat.myapplication.worker.view.history.RecycleHistory
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.fragment_admin_history_worker.*
import kotlinx.android.synthetic.main.fragment_history.*
import java.sql.Date


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 *
 */
class AdminHistoryWorker(val main : HomeAdmin) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_history_worker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getlistHistory()
        main.setSupportActionBar(toolbar)
        main.supportActionBar?.setDisplayShowTitleEnabled(false)
        tv_toolbar_title.text = "History"
        super.onViewCreated(view, savedInstanceState)
    }

    fun getlistHistory() {
        val x: ArrayList<History> = arrayListOf()
        val y = History(Date(2015, 4, 13), "SOS", 2.4)
        val y1 = History(Date(2015, 4, 13), "SOS", 2.4)
        val y2 = History(Date(2015, 4, 13), "SOS", 2.4)
        x.add(y)
        x.add(y1)
        x.add(y2)
        rv_list_history_user?.apply {
            val recyclableAdapter = x?.let { RecycleHistoryAdmin(main, it) }
            layoutManager = LinearLayoutManager(context)
            adapter = recyclableAdapter
        }
    }



        companion object {
        fun newInstance(main : HomeAdmin): AdminHistoryWorker = AdminHistoryWorker(main)
    }



}
