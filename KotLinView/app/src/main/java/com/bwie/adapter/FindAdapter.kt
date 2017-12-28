package com.bwie.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bwie.bean.findbean
import com.bwie.kotlinview.R
import com.bwie.view.FindxpActivity
import com.squareup.picasso.Picasso

/**
 * Created by cll on 2017/12/27.
 */
class FindAdapter (context:Context,list: ArrayList<findbean>): RecyclerView.Adapter<FindAdapter.Mhanler>() {
    private var context:Context=context
    private var list:ArrayList<findbean> = list
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FindAdapter.Mhanler {
        //TODO("not implemented") //To change body o created functions use File | Settings | File Templates.
         return Mhanler(LayoutInflater.from(context).inflate(R.layout.findview,parent,false));
    }

    override fun onBindViewHolder(holder: FindAdapter.Mhanler?, position: Int) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
       holder?.name?.text=list.get(position).name
        Picasso.with(context).load(list.get(position).bgPicture).into(holder?.img)
        holder?.buji?.setOnClickListener({
            var inten=Intent(context,FindxpActivity::class.java)
            inten.putExtra("findname",list.get(position).name)
            context.startActivity(inten)
        })
    }

    override fun getItemCount(): Int {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
       return list.size
    }


    class Mhanler(itemView:View?):RecyclerView.ViewHolder(itemView){
           var name:TextView=itemView!!.findViewById(R.id.findname);
           var img:ImageView=itemView!!.findViewById(R.id.beijingtu);
           var buji:RelativeLayout=itemView!!.findViewById(R.id.findr)
    }
}