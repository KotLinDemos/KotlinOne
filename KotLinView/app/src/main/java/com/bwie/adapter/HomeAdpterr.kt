package com.bwie.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bwie.bean.Homebean
import com.bwie.kotlinview.R
import com.squareup.picasso.Picasso

/**
 * Created by dell on 2017/12/27.
 */
class HomeAdpterr(context:Context,list:List<Homebean>): RecyclerView.Adapter<HomeAdpterr.MoHoder>() {
    private var context:Context=context
    private var list:List<Homebean> =list
    override fun getItemCount(): Int {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
       return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeAdpterr.MoHoder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return MoHoder(LayoutInflater.from(context).inflate(R.layout.home_item,parent,false))
    }

    override fun onBindViewHolder(holder: HomeAdpterr.MoHoder?, position: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //holder?.home_category?.text=list.get(position).issueList.get(1).itemList.get(position).data.
        var title=list.get(position).issueList.get(1).itemList.get(position).data.title
        holder?.home_title?.text=title
        //Picasso.with(context).load()
    }

    class MoHoder(itemview:View): RecyclerView.ViewHolder(itemview) {
       // var home_icon:ImageView=itemview!!.findViewById(R.id.home_icon)
      //  var home_feed:ImageView=itemview!!.findViewById(R.id.home_feed)
        var home_title:TextView=itemview!!.findViewById(R.id.home_title)
        //var home_category:TextView=itemview!!.findViewById(R.id.home_category)

    }
}