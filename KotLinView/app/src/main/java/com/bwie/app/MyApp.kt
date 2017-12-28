package com.bwie.app

import android.app.Application

import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by ${单巨廷} on 2017/12/28.
 */

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}
