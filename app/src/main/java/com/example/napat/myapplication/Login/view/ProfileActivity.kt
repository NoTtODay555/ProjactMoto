package com.example.napat.myapplication.Login.view

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.napat.myapplication.R
import com.example.napat.myapplication.database.UserInformation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_proflie.*

class ProfileActivity : AppCompatActivity() , View.OnClickListener{

    private val fireBaseAuth = FirebaseAuth.getInstance()!!
    private val databaseReference = FirebaseDatabase.getInstance().reference
    private val user  = fireBaseAuth.currentUser!!
    lateinit var profiles : ArrayList<UserInformation>
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profiles = arrayListOf()
        setContentView(R.layout.activity_proflie)
        textViewUserEmail.text = "Welcome" + user.email
        bt_logout.setOnClickListener(this)
        bt_saveProfile.setOnClickListener(this)

    }
    private fun initSaladMenu() {
        val proflieListener = object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Error ", "loadPost:onCancelled ${databaseError.toException()}")
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val proflie = dataSnapshot.getValue(UserInformation::class.java)
                    Log.e("test1",proflie?.name)
                    profiles.add(proflie!!)
                }

            }
        }
        Log.e("test2",profiles.toString())
        databaseReference.child("user").child(user.uid).addListenerForSingleValueEvent(proflieListener)
    }

    private fun saveUserInformation() {
        val name: String = editTextName.text.toString().trim()
        val address: String = editTextAddress.text.toString().trim()
        val userInformation = UserInformation(name, address, null, "Customer")
        val x = arrayListOf<UserInformation>()

        Log.e("check user", userInformation.toString())


        user.uid.run {
            databaseReference.child("user").child("costumer").setValue(userInformation)
            val a = databaseReference.child("user").child(this)
            Toast.makeText(this@ProfileActivity,a.toString(),Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(v: View?) {
        if (v == bt_logout){
            fireBaseAuth.signOut()
            finish()
            this.startActivity(Intent(this, Login::class.java))
        }
        if( v == bt_saveProfile){
            saveUserInformation()
            finish()
            this.startActivity(Intent(this, Login::class.java))
            initSaladMenu()
        }
    }



}
