package com.bwie.kotlinview

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bwie.fragments.FindFragment
import com.bwie.fragments.HomeFragment
import com.bwie.fragments.HotFragment
import com.bwie.fragments.MineFragment
import com.hjm.bottomtabbar.BottomTabBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btb.init(getSupportFragmentManager())
                .setImgSize(45f,45f)
                .setFontSize(10f)
                .setTabPadding(4f, 6f, 10f)
                .setChangeColor(Color.BLACK, Color.GRAY)
                .addTabItem("首页", R.mipmap.home_normal, HomeFragment::class.java)
                .addTabItem("发现", R.mipmap.find_normal, FindFragment::class.java)
                .addTabItem("热门", R.mipmap.hot_normal, HotFragment::class.java)
                .addTabItem("我的", R.mipmap.mine_normal, MineFragment::class.java)
                .isShowDivider(false)
                .setOnTabChangeListener(object : BottomTabBar.OnTabChangeListener{
                    override fun onTabChange(position: Int, name: String?) {

                    }

                });
    }
}
