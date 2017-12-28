package com.bwie.api

import com.bwie.bean.Homebean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by dell on 2017/12/27.
 */
interface ApiService{
    //http://baobab.kaiyanapp.com/api/v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    @GET("feed")
    fun getHome(@Query("num") num:Int,@Query("udid") udid:String,@Query("vc") vc:Int):Flowable<Homebean>

}