package com.bwie.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by 朝朝暮暮 on 2017/12/28.
 */
class RetrofitUtils(baseUrl:String){


    var url:String = baseUrl
    var okHttpClient : OkHttpClient? = null
    var retrofit : Retrofit? = null

    init {
        //创建okhttp
        okHttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(
                        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(5000,TimeUnit.SECONDS)
                .readTimeout(5000,TimeUnit.SECONDS)
                .build()

        //创建retrofit
        retrofit = Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    companion object {

        @Volatile
        var instance: RetrofitUtils? = null
        fun getInstance(baseUrl:String): RetrofitUtils {
            if(instance==null){
                synchronized(RetrofitUtils::class.java){
                    if(instance==null){
                        instance = RetrofitUtils(baseUrl)
                    }
                }
            }
            return instance!!
        }



    }
    fun <T> getApisercices(service:Class<T>?): T? {

        if(service==null){
            throw RuntimeException("Api service is null!")
        }
        return retrofit?.create(service)
    }
}