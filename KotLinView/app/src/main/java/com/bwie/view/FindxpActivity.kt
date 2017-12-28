package com.bwie.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.bwie.adapter.FindxqAdapter
import com.bwie.bean.findxqbean
import com.bwie.kotlinview.R
import com.bwie.presenter.FindxqPresenter
import kotlinx.android.synthetic.main.activity_findxp.*

class FindxpActivity : AppCompatActivity() ,IFindxqView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_findxp)
        var recy=findViewById(R.id.findxqrv) as RecyclerView
        var name=findViewById(R.id.findccc) as TextView
        var int=intent.getStringExtra("findname")
        name!!.text=int
        var pre=FindxqPresenter(this)
        pre!!.xq(int)
    }
    override fun showData(findxqlist: findxqbean) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val itemList = findxqlist.itemList
        var adapter= FindxqAdapter(this, findxqlist.itemList!!)
//        var  recy=findViewById(R.id.findxqrv) as RecyclerView
        findxqrv.layoutManager= LinearLayoutManager(this)
        findxqrv.adapter=adapter
    }
}

