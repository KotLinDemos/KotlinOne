package com.bwie.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bwie.kotlinview.R

/**
 * Created by ${单巨廷} on 2017/12/27.
 */
class MineFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.mine_fragment, container, false)
        return view
    }
}