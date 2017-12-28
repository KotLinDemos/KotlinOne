package com.bwie.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bwie.kotlinview.AdviseActivity
import com.bwie.kotlinview.R
import com.bwie.kotlinview.SaveActivity
import com.bwie.kotlinview.WatchActivity

/**
 * Created by ${单巨廷} on 2017/12/27.
 */
class MineFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.mine_fragment, container, false)
        val save = view.findViewById(R.id.tv_save) as TextView
        val pic=view.findViewById(R.id.pic) as ImageView
        val watch = view.findViewById(R.id.tv_watch) as TextView
        val advise = view.findViewById(R.id.tv_advise) as TextView
        watch.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var it3=Intent(activity, WatchActivity::class.java)
                startActivity(it3)
            }

        })

        advise.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var it2=Intent(activity,AdviseActivity::class.java)
                startActivity(it2)
            }

        })
        save.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                var it=Intent(activity, SaveActivity::class.java)
                startActivity(it)
            }
        })
        return view
    }
}