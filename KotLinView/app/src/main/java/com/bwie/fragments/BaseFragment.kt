package com.bwie.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by 朝朝暮暮 on 2017/12/27.
 */
abstract class BaseFragment : Fragment() {

    var isFragmentVisiable : Boolean = false
    var rootView : View? = null
    var isFirst : Boolean = false
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //判断是否初始化
        if(rootView==null){
            return inflater?.inflate(getLayoutId(),container,false)
        }
        return rootView
    }



    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initview()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if(isVisibleToUser){
            isFragmentVisiable = true
        }
        if(rootView==null){
            return
        }

        //由可见-->不可见  已经加载过了
        if (!isFirst&&isFragmentVisiable){
            onFragmentVisiableChange(true)
        }
    }

    open fun onFragmentVisiableChange(boolean: Boolean){

    }
    abstract fun getLayoutId(): Int
    abstract fun initview()
}