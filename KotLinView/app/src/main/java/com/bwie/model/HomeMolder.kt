package com.bwie.model

import com.bwie.api.A
import com.bwie.api.ApiService
import com.bwie.bean.Homebean
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Flowable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by dell on 2017/12/27.
 */
//num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
class HomeMolder{

   fun getDataMolder():Flowable<Homebean> {
       var retrofit = Retrofit.Builder().baseUrl(A.Datae)
               .addConverterFactory(GsonConverterFactory.create())
               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
               .build()
       val apiService = retrofit.create(ApiService::class.java)
       val flowable = apiService.getHome(2, "26868b32e808498db32fd51fb422d00175e179df", 83)
       return flowable;
   }
}