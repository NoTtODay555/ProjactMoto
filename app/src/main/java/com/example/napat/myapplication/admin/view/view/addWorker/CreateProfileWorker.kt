package com.example.napat.myapplication.admin.view.view.addWorker


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.napat.myapplication.R
import com.example.napat.myapplication.admin.view.presenter.GetFmAdmin
import com.example.napat.myapplication.admin.view.presenter.PresenterAdmin
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.admin.view.view.allError.DetailAdminlist
import com.example.napat.myapplication.admin.view.view.workerSec.MainAdmin
import com.example.napat.myapplication.database.All
import com.example.napat.myapplication.database.UserInformation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_proflie.*
import kotlinx.android.synthetic.main.fragment_create_profile_worker.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 *
 */
class CreateProfileWorker(val worker: HomeAdmin) : Fragment() {
    val getFm : PresenterAdmin = GetFmAdmin(worker)
    private val fireBaseAuth = FirebaseAuth.getInstance()!!
    private val databaseReference = FirebaseDatabase.getInstance().reference
    private val user  = fireBaseAuth.currentUser!!
    lateinit var profiles : ArrayList<UserInformation>
    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_profile_worker, container, false)
        profiles = arrayListOf()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_sign.setOnClickListener {
            saveUserInformation()
            val main = MainAdmin.newInstance(worker)
            getFm.openFragment(main)
        }
        super.onViewCreated(view, savedInstanceState)
    }


    private fun saveUserInformation() {
        val name: String = et_nickname.text.toString().trim()
        val address: String = et_talworker.text.toString().trim()
        val userInformation = UserInformation(name, address, null, "worker")
        Log.e("check user", userInformation.toString())


        user.uid.run {
            databaseReference.child("user").child(this).setValue(userInformation)
            val a = databaseReference.child("user").child(this)
            Toast.makeText(worker,a.toString(), Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        fun newInstance(worker: HomeAdmin): CreateProfileWorker = CreateProfileWorker( worker)
    }


}
