package com.bwie.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bwie.adapter.HomeAdpterr
import com.bwie.bean.Homebean
import com.bwie.bean.MoviesBean
import com.bwie.kotlinview.R
import com.bwie.presenter.HomePersenter
import com.bwie.view.DetailsActivity
import com.bwie.view.HomeView
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.title.*

/**
 * Created by ${单巨廷} on 2017/12/27.
 */
class HomeFragment : BaseFragment(),HomeView {
    override fun getLayoutId(): Int {
        return R.layout.home_fragment
    }

    override fun initview() {
        tv_title.setText("Friday")
        iv_title.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(context,"点了",Toast.LENGTH_SHORT).show()

                
            }

        })
        val goodsPersenter = HomePersenter(this)
        goodsPersenter.home()
    }



    override fun showDataa(homebean: Homebean) {
        Log.e("xxx",homebean.newestIssueType.toString())
        val itemList = homebean.issueList!!.get(0).itemList!!
       val homeAdpterr = HomeAdpterr(activity, itemList)
        var linearLayoutManager=LinearLayoutManager(activity)
        home_recyview.setLayoutManager(linearLayoutManager)
        var movies: MoviesBean = MoviesBean()

        homeAdpterr.setOniteClickListener(object :HomeAdpterr.OnItemClickLitener{
            override fun onItemClick(list: Homebean.IssueListBean.ItemListBean.DataBean?) {
                var intent = Intent()
                intent.setClass(context, DetailsActivity::class.java)

                movies.playUrl = list!!.playUrl!!
                movies.feed = list.cover!!.feed!!
                movies.blurred=list.cover!!.blurred!!
                movies.category=list.category!!
                movies.title=list.title!!
                movies.description=list.description!!
                movies.collectionCont=""+list.consumption!!.collectionCount!!
                movies.replyCount=""+list.consumption!!.replyCount!!
                movies.shareCount=""+list.consumption!!.shareCount!!

                intent.putExtra("movies",movies)
                startActivity(intent)
            }

        })
        home_recyview.adapter=homeAdpterr
    }
}