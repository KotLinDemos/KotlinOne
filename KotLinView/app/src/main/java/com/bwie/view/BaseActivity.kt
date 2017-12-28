package com.bwie.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<T> : AppCompatActivity() {

    var presenter:T? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initView()
        getPresenter()
        initData()
    }


    //获取布局Id
    abstract fun layoutId(): Int
    //初始化数据
    abstract fun initView()
    //关联P层
    internal abstract fun getPresenter():T
    //展示数据
    abstract fun initData()

}
