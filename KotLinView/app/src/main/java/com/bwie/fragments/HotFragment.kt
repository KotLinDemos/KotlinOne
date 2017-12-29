package com.bwie.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import com.bwie.adapter.HotAdapter
import com.bwie.kotlinview.R
import kotlinx.android.synthetic.main.hot_fragment.*
import kotlinx.android.synthetic.main.title.*

/**
 * Created by ${单巨廷} on 2017/12/27.
 */
class HotFragment : BaseFragment() {

    var STRATEGY = arrayOf("weekly","monthly","historical")
    lateinit var mFragments : ArrayList<Fragment>
    var mTabs = listOf<String>("周排行","月排行","总排行").toMutableList()
    override fun getLayoutId(): Int {
        return R.layout.hot_fragment
    }

    override fun initview() {

        tv_title.setText("Ranking")
        iv_title.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(context,"点了",Toast.LENGTH_SHORT).show()
            }

        })

        var weekFragment : SumFragment = SumFragment()
        var weekBundle = Bundle()
        weekBundle.putString("bin",STRATEGY[0])
        weekFragment.arguments = weekBundle

        var monthFragment : SumFragment = SumFragment()
        var monthBundle = Bundle()
        monthBundle.putString("bin",STRATEGY[1])
        monthFragment.arguments = monthBundle

        var sumFragment : SumFragment = SumFragment()
        var sumBundle = Bundle()
        sumBundle.putString("bin",STRATEGY[2])
        sumFragment.arguments = sumBundle

        mFragments = ArrayList()
        mFragments.add(weekFragment)
        mFragments.add(monthFragment)
        mFragments.add(sumFragment)

        viewPager.adapter = HotAdapter(fragmentManager,mFragments,mTabs)
        tabs.setViewPager(viewPager)

    }


}