package com.bwie.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.bwie.bean.CorretionBean

import com.bwie.kotlinview.R
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by dell on 2017/12/29.
 */
class CorretionAdpter(contet:Context, list: List<CorretionBean.ItemListBean>): RecyclerView.Adapter<CorretionAdpter.MyHolder>() {
    private var context:Context=contet
    private var list:List<CorretionBean.ItemListBean> = list

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CorretionAdpter.MyHolder {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.coorrelation_item,parent,false))
    }

    override fun getItemCount(): Int {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return list.size
    }

    override fun onBindViewHolder(holder: CorretionAdpter.MyHolder?, position: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder?.coorretion_title?.text=list.get(position).data?.title
        val feed = list.get(position).data?.cover?.feed
        holder?.coorretion_feed?.setImageURI(Uri.parse(feed))
        holder?.coorretion_category?.text=list.get(position).data?.category

        holder?.correemal_revice?.setOnClickListener(View.OnClickListener {
            litener?.onItemClick(list.get(position).data)
        })
    }
    class MyHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        var coorretion_feed=itemview.findViewById(R.id.coorretion_feed)  as SimpleDraweeView
        var coorretion_title=itemview.findViewById(R.id.coorretion_title)  as TextView
        var coorretion_category=itemview.findViewById(R.id.coorretion_category)  as TextView
        var correemal_revice=itemview.findViewById(R.id.correemal_revice)  as RelativeLayout


    }
    interface OnItemClickLitener{
        // fun onItemClick(position : Int)
        fun onItemClick(list: CorretionBean.ItemListBean.DataBean?)
    }
    var litener:OnItemClickLitener?=null
    fun setOniteClickListener(litener: OnItemClickLitener){
        this.litener=litener
    }

}