package com.bwie.api

import com.bwie.bean.findbean
import com.bwie.bean.findxqbean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by dell on 2017/12/27.
 */
interface ApiService{
    //http://baobab.kaiyanapp.com/api/v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    @GET("feed")
    fun getHome(@Query("num") num:String,@Query("udid") udid:String,@Query("vc") vc:String)
    @GET("categories")
    fun getFind(@Query("udid") udid: String,@Query("vc")vc: String):Flowable<List<findbean>>
    @GET("videos")
    fun getFindxq(@Query("categoryName")categoryName:String,@Query("udid")udid:String,@Query("vc")vc: String):Flowable<List<findxqbean.ItemListBean>>

}