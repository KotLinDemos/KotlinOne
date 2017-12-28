package com.bwie.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bwie.adapter.HomeAdpterr
import com.bwie.bean.Homebean
import com.bwie.kotlinview.R
import com.bwie.kotlinview.R.layout
import com.bwie.view.HomeView
import kotlinx.android.synthetic.main.home_fragment.*

/**
 * Created by ${单巨廷} on 2017/12/27.
 */
class HomeFragment : Fragment(),HomeView {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(layout.home_fragment, container, false)

        //var BeanActivity<Homebean>()
        var home_recyview=view.findViewById(R.id.home_recyview) as RecyclerView
        val linearLayoutManager = LinearLayoutManager(activity)
        home_recyview.setLayoutManager(linearLayoutManager)
        return view
    }
    override fun getData(homebean: List<Homebean>) {
        val homeAdpterr = HomeAdpterr(activity, homebean)
        home_recyview.adapter=homeAdpterr

    }
}