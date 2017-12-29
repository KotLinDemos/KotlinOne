package com.bwie.kotlinview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.title_activity.*

class AdviseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advise)
        tv_title_activity.setText("意见反馈")
        iv_title_back.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                finish()
            }

        })
    }
}
