package com.example.napat.myapplication.castomer.constuer

import android.util.Log
import com.example.napat.myapplication.castomer.presenter.CallDataAll
import com.example.napat.myapplication.castomer.presenter.ContentPre
import com.example.napat.myapplication.castomer.view.ConteckView
import com.example.napat.myapplication.database.Errors
import com.example.napat.myapplication.database.UserInformation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class GetDataCustomer(val main : ConteckView.User):Conteck.Data {
    val callDataAll : ContentPre = CallDataAll(this)
    override fun getDataUser(databaseReference: DatabaseReference, fireBaseAuth: FirebaseAuth) {
        callDataAll.dataUser(databaseReference,fireBaseAuth)
    }

    override fun dataUser(list : UserInformation,lists : Errors) {
        Log.e("test",lists.toString())
        main.getlistUser(list,lists)
    }

}