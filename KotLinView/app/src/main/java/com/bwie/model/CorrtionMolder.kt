package com.bwie.model

import android.support.v7.widget.RecyclerView
import com.bwie.api.A
import com.bwie.api.ApiService
import com.bwie.bean.CorretionBean
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Flowable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by dell on 2017/12/29.
 */
class CorrtionMolder{
    fun getCoortion(query:String):Flowable<CorretionBean>{
        val retrofit = Retrofit.Builder().baseUrl(A.Corrtion)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        val apiService = retrofit.create(ApiService::class.java)
        // http://baobab.kaiyanapp.com/api/v1/search?num=10&query=%E4%BD%A0&start=10
        val flowable = apiService.getSearch(10, query, 10)
        return flowable
    }
}