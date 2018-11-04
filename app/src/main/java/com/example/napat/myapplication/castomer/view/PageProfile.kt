package com.example.napat.myapplication.castomer.view


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.napat.myapplication.Login.view.Login

import com.example.napat.myapplication.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_page_profile.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 *
 */
class PageProfile(val home : HomeCustomer) : Fragment() , View.OnClickListener {

    private val fireBaseAuth = FirebaseAuth.getInstance()!!

    override fun onClick(v: View?) {
        when(v) {
            bt_logout_profile -> {
                fireBaseAuth.signOut()
                this.startActivity(Intent(home, Login::class.java))
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bt_logout_profile.setOnClickListener(this)

        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(home : HomeCustomer): PageProfile = PageProfile(home)
    }


}
