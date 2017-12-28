package com.bwie.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by 朝朝暮暮 on 2017/12/27.
 */
class HotAdapter (fm: FragmentManager, list: ArrayList<Fragment>, titles : MutableList<String>) : FragmentPagerAdapter(fm){

    var mList : ArrayList<Fragment> = list
    var mTitles : MutableList<String> = titles
    var mFm : FragmentManager = fm
    override fun getItem(position: Int): Fragment {
        return mList[position]
    }

    override fun getCount(): Int {
        return mList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mTitles[position]
    }
}