package com.bwie.kotlinview

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_save.*
import kotlinx.android.synthetic.main.title_activity.*

class SaveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)
        tv_title_activity.setText("我的缓存")
        iv_title_back.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                finish()
            }

        })

        var shard : SharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE)
        var playurl = shard.getString("playurl",null)
        var title = shard.getString("title",null)
        var feed = shard.getString("feed",null)

        if(playurl == null){
            tv_hint.visibility = View.VISIBLE
        }else{
            tv_save.setText(title)
            simple.setImageURI(Uri.parse(feed))
        }



    }
}
