package com.bwie.view

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import com.bwie.adapter.FindxqAdapter
import com.bwie.bean.findxqbean
import com.bwie.kotlinview.R

import com.bwie.presenter.FindxqPresenter

class FindxpActivity : BaseActivity<FindxqPresenter>() ,IFindxqView{
    override fun showData(findxqlist: List<findxqbean.ItemListBean>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var adapter=FindxqAdapter(this,findxqlist as ArrayList<findxqbean.ItemListBean>)
        var  recy=findViewById(R.id.findxqrv) as RecyclerView;
        recy.layoutManager=LinearLayoutManager(this)
        recy.adapter=adapter
    }

    override fun layoutId(): Int=R.layout.activity_findxp
    override fun initView() {
        var  recy=findViewById(R.id.findxqrv) as RecyclerView;
        var findccc=findViewById(R.id.findccc) as TextView
        var intent=getIntent()
        var name:String= intent.getStringExtra("findname")
        Log.i("xxx",name.toString())
        findccc?.text=name
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPresenter(): FindxqPresenter {
        return  FindxqPresenter(this)
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        presenter!!.xq()
    }


}
