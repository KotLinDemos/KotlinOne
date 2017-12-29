package com.bwie.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bwie.bean.Homebean
import com.bwie.kotlinview.R
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by dell on 2017/12/27.
 */
class HomeAdpterr(context:Context,list:List<Homebean.IssueListBean.ItemListBean>): RecyclerView.Adapter<HomeAdpterr.MoHoder>() {
    private var context:Context=context

    private var list: List<Homebean.IssueListBean.ItemListBean> = list
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


        var feed:String? = null
        var playUrl:String? = null
        var title:String? = null
        var category:String? = null
        var icon:String? = null
        var description:String? = null
        val bean = list?.get(position)
        var minute = bean?.data?.duration?.div(60)
        var second = bean?.data?.duration?.minus((minute?.times(60)) as Long )
     /*   var realMinute : String
        var realSecond : String
        if(minute!!<10){
            realMinute = "0"+minute
        }else{
            realMinute = minute.toString()
        }
        if(second!!<10){
            realSecond = "0"+second
        }else{
            realSecond = second.toString()
        }*/
            if(position>0){
                var bean = list.get(position)
                var minute = bean?.data?.duration?.div(60)

                feed = list.get(position).data?.cover?.feed
                icon = list.get(position).data?.author?.icon

                title=list.get(position).data?.title
                category = list.get(position).data?.category
                //description = list.get(position).data?.description
                playUrl=list.get(position).data?.playUrl
                Log.e("TAG",playUrl)
            }else{
                feed = list.get(4).data?.cover?.feed
                icon = list.get(4).data?.author?.icon
                title=list.get(4).data?.title
                category = list.get(4).data?.category
//                playUrl=list.get(4).data?.playUrl
            }
        holder?.home_feed?.setImageURI(Uri.parse(feed))
        holder?.home_title?.text=title
        holder?.home_category?.text="发布于 $category"
        holder?.home_icon?.setImageURI(Uri.parse(icon))
       //holder?.home_category?.text = "发布于 $category/ $realMinute:$realSecond"

        holder?.home_feed?.setOnClickListener{
            litener?.onItemClick(list.get(position).data)
          /*  var intent:Intent=Intent(context,DetailsActivity::class.java)
           *//* intent.putExtra("playUrl",playUrl)
            intent.putExtra("description",description)*//*
            context.startActivity(intent)*/
        }
    }

    class MoHoder(itemview:View): RecyclerView.ViewHolder(itemview) {
        var home_icon:SimpleDraweeView=itemview!!.findViewById(R.id.home_icon)
        var home_feed: SimpleDraweeView =itemview!!.findViewById(R.id.home_feed)
        var home_title:TextView=itemview!!.findViewById(R.id.home_title)
        var home_category:TextView=itemview!!.findViewById(R.id.home_category)
    }



    interface OnItemClickLitener{
       // fun onItemClick(position : Int)
       fun onItemClick(list: Homebean.IssueListBean.ItemListBean.DataBean?)
    }
    var litener:OnItemClickLitener?=null
    fun setOniteClickListener(litener: OnItemClickLitener){
        this.litener=litener
    }

}