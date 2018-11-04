package com.example.napat.myapplication.admin.view.view.addWorker


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.napat.myapplication.Login.view.ProfileActivity

import com.example.napat.myapplication.R
import com.example.napat.myapplication.admin.view.presenter.GetFmAdmin
import com.example.napat.myapplication.admin.view.presenter.PresenterAdmin
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_worker_list_admin.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 *
 */
class WorkerListAdmin (val main : HomeAdmin): Fragment() {
    private val fireBaseAuth = FirebaseAuth.getInstance()!!
    val getFm : PresenterAdmin = GetFmAdmin(main)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_worker_list_admin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        bt_gotovreatProfile.setOnClickListener {
            registerUser()
        }
        super.onViewCreated(view, savedInstanceState)
    }
    private fun registerUser() {
        val email = et_userWorker?.text.toString().trim()
        val password = et_passwordWorker?.text.toString().trim()

        if(TextUtils.isEmpty(email)){
            Toast.makeText(main,"Please enter email", Toast.LENGTH_LONG).show()
            return
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(main,"Please enter password", Toast.LENGTH_LONG).show()
            return
        }

        fireBaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(main) { task ->
            //checking if success
            if (task.isSuccessful) {
                Log.e("Checkcreate", "isSuccessful")
                Toast.makeText(main,"Successfully registered", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(main,"Registration Error", Toast.LENGTH_SHORT).show()
            }

        }
        fireBaseAuth.signInWithEmailAndPassword(email , password).addOnCompleteListener(main){
            if (it.isSuccessful) {
                Log.e("CheckSingin", "isSuccessful")
                val createProfileWorker = CreateProfileWorker.newInstance(main)
                getFm.openFragment(createProfileWorker)
            } else {
                Toast.makeText(main,"Login Error", Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        fun newInstance(main : HomeAdmin): WorkerListAdmin = WorkerListAdmin(main)
    }

}
