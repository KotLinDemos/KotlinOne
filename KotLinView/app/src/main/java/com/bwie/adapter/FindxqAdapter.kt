package com.bwie.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bwie.bean.findxqbean
import com.bwie.kotlinview.R
import com.squareup.picasso.Picasso


/**
 * Created by cll on 2017/12/28.
 */
class FindxqAdapter (content:Context,list: ArrayList<findxqbean.ItemListBean>) : RecyclerView.Adapter<FindxqAdapter.Mhlder>() {
    private var content:Context=content
    private var list:ArrayList<findxqbean.ItemListBean> =list

    override fun onBindViewHolder(holder: FindxqAdapter.Mhlder?, position: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder?.chuan?.text=list.get(0).data!!.category;
        holder?.name?.text=list.get(position).data!!.title
        var a: Int =list.get(position).data!!.duration
        Log.i("xxx",a.toString())
        holder?.shi?.text= a.toString()
        Picasso.with(content).load(list.get(position).data!!.cover!!.feed).into(holder?.img)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FindxqAdapter.Mhlder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return Mhlder(LayoutInflater.from(content).inflate(R.layout.findview,parent,false))
    }

    override fun getItemCount(): Int {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
       return list.size
    }
    class Mhlder(itemview:View?) :RecyclerView.ViewHolder(itemview){
           var img:ImageView=itemview!!.findViewById(R.id.findxqtu)
        var name:TextView=itemview!!.findViewById(R.id.findxqnamee)
        var chuan:TextView=itemview!!.findViewById(R.id.chuanguolai)
        var shi:TextView=itemview!!.findViewById(R.id.findxqshijin)
    }
}