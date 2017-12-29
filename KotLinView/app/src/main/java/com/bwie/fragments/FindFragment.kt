package com.bwie.fragments

import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.bwie.adapter.FindAdapter
import com.bwie.bean.findbean
import com.bwie.kotlinview.R
import com.bwie.presenter.FindPresenter
import com.bwie.view.IFindview
import kotlinx.android.synthetic.main.find_fragment.*
import kotlinx.android.synthetic.main.title.*

/**
 * Created by ${单巨廷} on 2017/12/27.
 */
class FindFragment : BaseFragment() ,IFindview {
    override fun getLayoutId(): Int {
        return R.layout.find_fragment
    }

    override fun initview() {

        tv_title.setText("Ranking")
        iv_title.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(context,"点了",Toast.LENGTH_SHORT).show()
            }

        })

        var pre= FindPresenter(this)
        pre!!.ff()
    }

    override fun findData(findlist: List<findbean>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        var adapter=FindAdapter(context,findlist as ArrayList<findbean>)

        findrlv.layoutManager=GridLayoutManager(context,2)
        findrlv.adapter=adapter
    }
}