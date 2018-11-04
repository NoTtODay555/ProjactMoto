package com.example.napat.myapplication.castomer.view


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*

import com.example.napat.myapplication.R
import com.example.napat.myapplication.castomer.constuer.Contact
import com.example.napat.myapplication.castomer.constuer.Conteck
import com.example.napat.myapplication.castomer.constuer.GetFM
import kotlinx.android.synthetic.main.activity_home_customers_button.*
import kotlinx.android.synthetic.main.activity_home_customter.*
import kotlinx.android.synthetic.main.activity_home_worker.*
import kotlinx.android.synthetic.main.fragment_page_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 *
 */
class PageHome(var main : HomeCustomer) : Fragment() {


    private var getFM : Conteck = GetFM(main)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_home, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
    }





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(main : HomeCustomer): PageHome = PageHome(main)
    }



}
