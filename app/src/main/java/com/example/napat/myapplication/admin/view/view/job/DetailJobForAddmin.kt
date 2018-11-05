package com.example.napat.myapplication.admin.view.view.job


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.napat.myapplication.R
import com.example.napat.myapplication.admin.view.presenter.GetFmAdmin
import com.example.napat.myapplication.admin.view.presenter.PresenterAdmin
import com.example.napat.myapplication.admin.view.view.HomeAdmin
import com.example.napat.myapplication.database.All
import com.example.napat.myapplication.database.Errors
import kotlinx.android.synthetic.main.fragment_detail_job_for_addmin.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@SuppressLint("ValidFragment")
/**
 * A simple [Fragment] subclass.
 *
 */
class DetailJobForAddmin(val worker: HomeAdmin,val list :All) : Fragment() {
    val getFmAdmin: PresenterAdmin = GetFmAdmin(worker)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_job_for_addmin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_name_user.text = list.username
        tv_problem_job.text = list.proplams
        tv_tell_job_user.text = list.tel
        bt_send_worker.setOnClickListener {
            if(tv_id_worker.text.isEmpty()){
                Toast.makeText(worker,"Plase Select Worker", Toast.LENGTH_SHORT).show()
            }else{
                val test = JobMainAdin.newInstance(worker)
                getFmAdmin.openFragment(test)
            }
        }
        bt_return_worker_list.setOnClickListener {

        }
    }

    companion object {
        fun newInstance(worker: HomeAdmin,list : All): DetailJobForAddmin = DetailJobForAddmin(worker,list)
    }

}
