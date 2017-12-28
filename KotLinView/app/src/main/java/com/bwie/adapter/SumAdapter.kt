package com.bwie.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bwie.bean.HotBean
import com.bwie.kotlinview.R
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by 朝朝暮暮 on 2017/12/28.
 */
class SumAdapter(context:Context,list:List<HotBean.ItemListBean>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mcontext:Context = context
    var mlist:List<HotBean.ItemListBean> = list

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var viewholder:MyViewHolder = holder as MyViewHolder

        viewholder.tv_connect.setText(mlist.get(position).data!!.title)
        viewholder.tv_blow.setText(mlist.get(position).data!!.category+"/")
        viewholder.iv_bg.setImageURI(Uri.parse(mlist.get(position).data!!.cover!!.detail))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.adapter_sum,parent,false))
    }

    override fun getItemCount(): Int {
        return mlist.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var iv_bg : SimpleDraweeView = itemView.findViewById(R.id.iv_bg)
        var tv_connect : TextView = itemView.findViewById(R.id.tv_connect)
        var tv_blow : TextView = itemView.findViewById(R.id.tv_blow)
    }
}