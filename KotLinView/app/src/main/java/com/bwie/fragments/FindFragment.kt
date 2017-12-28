package com.bwie.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bwie.adapter.FindAdapter
import com.bwie.bean.findbean
import com.bwie.kotlinview.R
import com.bwie.presenter.FindPresenter
import com.bwie.view.IFindview

/**
 * Created by ${单巨廷} on 2017/12/27.
 */
class FindFragment : Fragment() ,IFindview {
    override fun findData(findlist: List<findbean>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        var adapter=FindAdapter(activity,findlist as ArrayList<findbean>)
        var re=view!!.findViewById(R.id.findr) as RecyclerView;

        re.layoutManager=GridLayoutManager(activity,2)
        re.adapter=adapter
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.find_fragment, container, false)
        var re=view.findViewById(R.id.findr) as RecyclerView;
        var pre= FindPresenter(this)
        pre!!.ff()
        return view
    }
}