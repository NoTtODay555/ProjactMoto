package com.example.napat.myapplication.castomer.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.napat.myapplication.R
import kotlinx.android.synthetic.main.activity_home_customers_button.*

class HomeCustomersButton : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v){
            bt_sos -> {
                this.finish()
                val x ="sos"
                this.startActivity(Intent(this, HomeCustomer:: class.java).putExtra("test",x))
            }
            btOilOut -> {
                this.finish()
                val x ="OilOut"
                this.startActivity(Intent(this, HomeCustomer:: class.java).putExtra("test",x))
            }
            btBrokenTired -> {
                this.finish()
                val x ="BrokenTired"
                this.startActivity(Intent(this, HomeCustomer:: class.java).putExtra("test",x))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_customers_button)
        bt_sos.setOnClickListener(this)
        btOilOut.setOnClickListener(this)
        btBrokenTired.setOnClickListener(this)

    }

}
