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
class HomeAdpterr(context:Context,list:Homebean): RecyclerView.Adapter<HomeAdpterr.MoHoder>() {
    private var context:Context=context

    private var list: Homebean = list
    override fun getItemCount(): Int {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
       return list.issueList!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeAdpterr.MoHoder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return MoHoder(LayoutInflater.from(context).inflate(R.layout.home_item,parent,false))
    }

    override fun onBindViewHolder(holder: HomeAdpterr.MoHoder?, position: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
       // holder?.home_category?.text=list.issueList.get(position).itemList.get(1)
       // var title=list.issueList.get(1).itemList.get(position).data.title
      /*  for(var i:Int=1;i<list.issueList!!.size;i++){

        }*/
      /*  var listt= ArrayList<String>()
        var positio:Int=1
        for(positio in listt){
            listt.add(positio)
        }*/
        var bean = list.issueList!!.get(position).itemList!!.get(2)
        var realMinute : String
        var realSecond : String
        var minute = bean?.data?.duration?.div(60)
        var second = bean?.data?.duration?.minus((minute?.times(60)) as Long )
        holder?.home_title?.text=list.issueList!!.get(position).itemList!!.get(2).data!!.title
        if(minute!!<10){
            realMinute = "0"+minute
        }else{
            realMinute = minute.toString()
        }
        if(second!!<10){
            realSecond = "0"+second
        }else{
            realSecond = second.toString()
        }
        //holder?.home_category?.text=
        val category = list.issueList!!.get(position).itemList!!.get(2).data!!.category
        holder?.home_category?.text = "发布于 $category/ $realMinute:$realSecond"

        val icon = list.issueList!!.get(position).itemList!!.get(2).data!!.author!!.icon
        Picasso.with(context).load(icon).placeholder(R.mipmap.ic_launcher).into(holder?.home_icon)

        val feed = list.issueList!!.get(position).itemList!!.get(2).data!!.cover!!.feed
        Picasso.with(context).load(feed).placeholder(R.mipmap.ic_launcher).into(holder?.home_feed)
        holder?.home_feed?.setOnClickListener{
            litener?.onItemClick(position)
        }

    }

    class MoHoder(itemview:View): RecyclerView.ViewHolder(itemview) {
        var home_icon:ImageView=itemview!!.findViewById(R.id.home_icon)
        var home_feed:ImageView=itemview!!.findViewById(R.id.home_feed)
        var home_title:TextView=itemview!!.findViewById(R.id.home_title)
        var home_category:TextView=itemview!!.findViewById(R.id.home_category)
    }
    interface OnItemClickLitener{
        fun onItemClick(position : Int)
    }
    var litener:OnItemClickLitener?=null
    fun setOniteClickListener(litener: OnItemClickLitener){
        this.litener=litener
    }
}