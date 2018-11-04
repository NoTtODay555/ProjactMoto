package com.example.napat.myapplication.castomer.view


import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.media.Rating
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.RatingBar

import com.example.napat.myapplication.R
import com.example.napat.myapplication.castomer.constuer.Conteck
import com.example.napat.myapplication.castomer.constuer.GetFM
import com.example.napat.myapplication.castomer.presenter.ViewDialog
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.dialog_rateing.*
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlinx.android.synthetic.main.fragment_page.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 *
 */
class DetailWorkerReady(val main:HomeCustomer) : Fragment() {

    lateinit var  viewDialog: ViewDialog
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    @SuppressLint("InflateParams")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        main.setSupportActionBar(toolbar)
        main.supportActionBar?.setDisplayShowTitleEnabled(false)
        tv_toolbar_title.text = "Service"
        compleat.setOnClickListener {
            viewDialog = ViewDialog(main)
            viewDialog?.showDialogRateing()
            val buttonCancel = viewDialog.dialog?.findViewById(R.id.rb_worker) as RatingBar
            buttonCancel.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
                ratingBar.setIsIndicator(true)
                viewDialog.hideDialog()
                viewDialog.showDialogthang()
                val handler = Handler()
                handler.postDelayed({
                    //...here i'm waiting 5 seconds before hiding the custom dialog
                    //...you can do whenever you want or whenever your work is done
                    viewDialog.hideDialog()
                    main.finish()
                    main.startActivity(Intent(main, HomeCustomersButton:: class.java))
                }, 5000)


            }
        }





    }


    companion object {
        fun newInstance(main:HomeCustomer): DetailWorkerReady = DetailWorkerReady(main)
    }

}
