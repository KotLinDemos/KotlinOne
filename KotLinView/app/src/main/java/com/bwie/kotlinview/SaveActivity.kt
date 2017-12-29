package com.bwie.kotlinview

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_save.*

class SaveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)


        var shard : SharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE)
        var playurl = shard.getString("playurl",null)
        var title = shard.getString("title",null)
        var feed = shard.getString("feed",null)

        if(playurl == null){
            tv_hint.visibility = View.VISIBLE
        }
        Log.e("TAG",playurl+"哈哈哈"+title)
    }
}
