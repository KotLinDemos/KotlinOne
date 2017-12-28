package com.bwie.model

import com.bwie.api.A
import com.bwie.api.ApiService
import com.bwie.api.RetrofitUtils
import com.bwie.bean.HotBean
import io.reactivex.Flowable

/**
 * Created by 朝朝暮暮 on 2017/12/28.
 */
class HotModel(){


    fun getData(bin:String) : Flowable<HotBean> {
        val retrofitUtil : RetrofitUtils = RetrofitUtils.getInstance(A.TEST)
        val apiService = retrofitUtil.getApisercices(ApiService::class.java)
        return apiService!!.getHotData(10,bin!!,"26868b32e808498db32fd51fb422d00175e179df",83)
    }




}