package com.bwie.api

import com.bwie.bean.Homebean
import com.bwie.bean.HotBean
import com.bwie.bean.findbean
import com.bwie.bean.findxqbean
import com.bwie.sctouxiang.ResultBean
import com.bwie.sctouxiang.UserBean
import io.reactivex.Flowable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


/**
 * Created by dell on 2017/12/27.
 */
interface ApiService{
    //http://baobab.kaiyanapp.com/api/v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    @GET("feed")
    fun getHome(@Query("num") num:Int,@Query("udid") udid:String,@Query("vc") vc:Int):Flowable<Homebean>

    @GET("categories")
    fun getFind(@Query("udid") udid: String,@Query("vc")vc: String):Flowable<List<findbean>>
    @GET("videos")
    fun getFindxq(@Query("categoryName")categoryName:String,@Query("udid")udid:String,@Query("vc")vc: String):Flowable<findxqbean>


    @GET("v3/ranklist")
    fun getHotData(@Query("num")num:Int,@Query("strategy")strategy:String,@Query("udid")udid:String,
                   @Query("vc")vc:Int) : Flowable<HotBean>

    //上传头像
    //https://www.zhaoapi.cn/file/upload

    @Multipart
    @POST("file/upload")
    fun uploadPic(@Part("uid") uid: RequestBody, @Part file: MultipartBody.Part): Call<ResultBean>

    @GET("user/getUserInfo?uid=552&token=4B5DAF274221936555E01E5F7BC271F4")
    fun getdd(): Flowable<UserBean>

}