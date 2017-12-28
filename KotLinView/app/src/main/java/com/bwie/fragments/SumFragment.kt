package com.bwie.fragments

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.bwie.adapter.SumAdapter
import com.bwie.bean.HotBean
import com.bwie.kotlinview.R
import com.bwie.presenter.HotPresenter
import com.bwie.view.DetailsActivity
import com.bwie.view.IHotView
import kotlinx.android.synthetic.main.fragment_sum.*

/**
 * Created by 朝朝暮暮 on 2017/12/27.
 */
class SumFragment : BaseFragment(),IHotView {


    lateinit var mStrategy : String

    lateinit var mPresenter:HotPresenter
    override fun getLayoutId(): Int {
        return R.layout.fragment_sum
    }

    override fun initview() {
        rv.layoutManager = LinearLayoutManager(context)

        if(arguments!=null){
            mStrategy = arguments.getString("bin")

            mPresenter = HotPresenter(this)
            mPresenter.lianjie(mStrategy)

        }
    }
    override fun getData(bean: HotBean) {

        val adapter = SumAdapter(context, bean.itemList!!)
        rv.adapter = adapter
        adapter.setOnItemClickListener(object : SumAdapter.OnItemClickLitener{
            override fun onItemClick(list: HotBean.ItemListBean.DataBean?) {
                var intent = Intent()
                intent.setClass(context, DetailsActivity::class.java)

                intent.putExtra("moviesUrl",list!!.playUrl)
                startActivity(intent)
            }

        })
        adapter.notifyDataSetChanged()
    }
}