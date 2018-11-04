package com.example.napat.myapplication.worker.view.history


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.napat.myapplication.R
import com.example.napat.myapplication.database.History
import com.example.napat.myapplication.worker.view.HomeWorker
import com.example.napat.myapplication.worker.view.main.RecycleView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_list_work.*
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
class Historys(val main : HomeWorker) : Fragment() {
    private val fireBaseAuth = FirebaseAuth.getInstance()!!
    private val databaseReference = FirebaseDatabase.getInstance().reference
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getlistHistory()
        main.setSupportActionBar(toolbar)
        main.supportActionBar?.setDisplayShowTitleEnabled(false)
        tv_toolbar_title.text = "History"
        super.onViewCreated(view, savedInstanceState)
    }
    fun getlistHistory(){
        val x : ArrayList<History> = arrayListOf()
        val y = History(Date(2015,4,13),"SOS",2.4)
        val y1 = History(Date(2015,4,13),"SOS",2.4)
        val y2 = History(Date(2015,4,13),"SOS",2.4)
        x.add(y)
        x.add(y1)
        x.add(y2)
        rv_list_history?.apply {
            val recyclableAdapter  = x?.let { RecycleHistory(main, it) }
            layoutManager = LinearLayoutManager(context)
            adapter = recyclableAdapter
        }

    }

    companion object {
        fun newInstance(main : HomeWorker): Historys = Historys(main)
    }





}
