package com.example.napat.myapplication.worker.view


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.napat.myapplication.R
import com.example.napat.myapplication.castomer.constuer.Contact
import com.example.napat.myapplication.database.All
import com.example.napat.myapplication.database.Errors
import com.example.napat.myapplication.worker.constuer.CallError
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_list_work.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 *
 */
class ListWork (val worker: HomeWorker): Fragment() ,workConstuView {


    private val fireBaseAuth = FirebaseAuth.getInstance()!!
    private val databaseReference = FirebaseDatabase.getInstance().reference
    val callListError : Contact.List = CallError(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_work, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callListError.getDataError(databaseReference,fireBaseAuth)

    }
    override fun listDataError(list: Errors) {
        val recyclableAdapter  = list?.let { RecycleView(worker, it) }
        rv_list?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclableAdapter
        }
    }

    companion object {
        fun newInstance(main : HomeWorker): ListWork = ListWork(main)
    }



}
