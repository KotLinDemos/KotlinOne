package com.bwie.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bwie.kotlinview.PicActivity
import com.bwie.kotlinview.R

/**
 * Created by ${单巨廷} on 2017/12/27.
 */
class MineFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.mine_fragment, container, false)
        val pic = view.findViewById(R.id.pic) as ImageView
        pic.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                var it=Intent(activity,PicActivity::class.java)
                startActivity(it)
            }
        })
        return view
    }
}