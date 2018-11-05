package com.example.napat.myapplication.castomer.view


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.napat.myapplication.R
import com.example.napat.myapplication.castomer.constuer.Conteck
import com.example.napat.myapplication.castomer.constuer.GetDataCustomer
import com.example.napat.myapplication.database.All
import com.example.napat.myapplication.database.Errors
import com.example.napat.myapplication.database.UserInformation
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.fragment_page.*
import android.app.ProgressDialog
import android.os.Handler
import com.example.napat.myapplication.castomer.constuer.GetFM
import com.example.napat.myapplication.castomer.presenter.ViewDialog
import kotlinx.android.synthetic.main.dialogprocress.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 *
 */
class Page (val main:HomeCustomer): Fragment(), OnMapReadyCallback, ConteckView.User {
    val x = main.intent.getStringExtra("test")
    private lateinit var mMap: GoogleMap
    private val fireBaseAuth = FirebaseAuth.getInstance()!!
    val getFM : Conteck = GetFM(main)
    val listError : ArrayList<All>? = arrayListOf()
    private val user = fireBaseAuth.currentUser
    private val databaseReference = FirebaseDatabase.getInstance().reference
    val callData : Conteck.Data = GetDataCustomer(this)
    lateinit var  viewDialog:ViewDialog

    override fun getlistUser(list: UserInformation,lists : Errors) {
        val tell = et_tell.text.toString().trim()
        val error = All (0.0,x,0.0, tell,user!!.uid, list.name?: user.email.toString())
        lists.listAll.filter { it.uid == user.uid }?.isNotEmpty()?.let {
            when (true){
                it -> {
                    lists.listAll.removeAll(lists.listAll.filter { it.uid == user.uid })
                    lists.listAll.add(error)
                }
                else -> {
                    lists.listAll.add(error)
                }
            }
        }
        listError?.add(error)
        Log.e("Show", error.toString())

        user.uid.run {
            databaseReference.child("error").child(user.uid).setValue(error)
        }
        databaseReference.child("error").setValue(lists)
        Toast.makeText(main,"Successfully", Toast.LENGTH_SHORT).show()

        workerReady()
    }

    fun workerReady(){
        viewDialog.hideDialog()
        val x = DetailWorkerReady.newInstance(main)
        getFM.openFragment(x)
    }


    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        et_error.text = x
        main.setSupportActionBar(toolbar)
        main.supportActionBar?.setDisplayShowTitleEnabled(false)
        tv_toolbar_title.text = "Service"
        bt_problem.setOnClickListener {
            callData.getDataUser(databaseReference,fireBaseAuth)
            viewDialog = ViewDialog(main)
            viewDialog?.showDialog()

        }

    }

    companion object {
        fun newInstance(main:HomeCustomer): Page = Page(main)
    }


}
