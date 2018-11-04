package com.example.napat.myapplication.castomer.presenter

import android.app.Activity
import android.app.Dialog
import android.os.Handler
import android.util.Log
import android.view.Window
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop
import com.example.napat.myapplication.R.id.custom_loading_imageView
import android.view.Window.FEATURE_NO_TITLE
import android.widget.RatingBar
import com.example.napat.myapplication.R
import com.example.napat.myapplication.R.id.rb_worker
import com.example.napat.myapplication.castomer.view.HomeCustomer
import kotlinx.android.synthetic.main.dialog_rateing.*


class ViewDialog(private val activity: Activity) {

    var dialog: Dialog? = null
    fun showDialog() {

        dialog = Dialog(activity)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        //...set cancelable false so that it's never get hidden
        dialog?.setCancelable(false)
        //...that's the layout i told you will inflate later
        dialog?.setContentView(R.layout.dialogprocress)
        //...initialize the imageView form infalted layout
        dialog?.show()
    }
    fun showDialogRateing() {

        dialog = Dialog(activity)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        //...set cancelable false so that it's never get hidden
        dialog?.setCancelable(false)
        //...that's the layout i told you will inflate later
        dialog?.setContentView(R.layout.dialog_rateing)
        //...initialize the imageView form infalted layout
        dialog?.show()
    }

    fun showDialogthang() {

        dialog = Dialog(activity)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        //...set cancelable false so that it's never get hidden
        dialog?.setCancelable(false)
        //...that's the layout i told you will inflate later
        dialog?.setContentView(R.layout.thang)

        //...initialize the imageView form infalted layout
        dialog?.show()
    }


    //..also create a method which will hide the dialog when some work is done
    fun hideDialog() {
        dialog?.dismiss()
    }
}