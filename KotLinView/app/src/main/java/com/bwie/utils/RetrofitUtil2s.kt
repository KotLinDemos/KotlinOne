package com.bwie.utils

/**
 * Created by 朝朝暮暮 on 2017/12/1.
 */

import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitUtil2s private constructor() {
    fun <T> getApiService(url: String, cl: Class<T>): T {
        val retrofit = getRetrofit(url)//得到retrofit

        return retrofit!!.create(cl)//返回的就是网络接口对象

    }

    companion object {
        private var retrofitUtils: RetrofitUtil2s? = null
        val instance: RetrofitUtil2s
            get() {
                if (retrofitUtils == null) {
                    synchronized(RetrofitUtil2s::class.java) {
                        if (retrofitUtils == null) {
                            retrofitUtils = RetrofitUtil2s()
                        }
                    }
                }
                return this!!.retrofitUtils!!
            }

        private var retrofit: Retrofit? = null
        @Synchronized
        fun getRetrofit(url: String): Retrofit? {
            val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.i("xxx", message) })
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .connectTimeout(5000, TimeUnit.SECONDS)
                    .readTimeout(5000, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(false)
                    .build()
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(url)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
            }
            return retrofit
        }

        annotation class Synchronized
    }


}
