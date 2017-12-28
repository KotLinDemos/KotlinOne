package com.bwie.model

import com.bwie.api.A
import com.bwie.api.ApiService
import com.bwie.bean.findxqbean
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Flowable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by cll on 2017/12/28.
 */
class FindxqModel () {

    fun getServerData():Flowable<List<findxqbean.ItemListBean>>{
        val retrofit=Retrofit.Builder().baseUrl(A.homefragment)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        val apiserver=retrofit.create(ApiService::class.java)
        val flowable=apiserver.getFindxq("游戏","26868b32e808498db32fd51fb422d00175e179df", "83")
        return flowable
    }
}