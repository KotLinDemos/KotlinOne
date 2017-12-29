package com.bwie.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import cn.jzvd.JZVideoPlayer
import cn.jzvd.JZVideoPlayerStandard
import com.bwie.bean.MoviesBean
import com.bwie.kotlinview.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val extras = intent.extras
        var movies : MoviesBean = extras.get("movies") as MoviesBean
        var video: JZVideoPlayerStandard = videoplayer


        video!!.setUp(movies.playUrl,JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,movies.title)
//        video.thumbImageView.setImageURI(Uri.parse("http://img.kaiyanapp.com/29b4b68d7210ece1cba8e45ab10ce349.png?imageMogr2/quality/60/format/jpg"))
//        JZVideoPlayerStandard.startFullscreen(this,JZVideoPlayerStandard::class.jwava,get.toString(),"辛苦了")
        Picasso.with(this)
                .load(movies.feed)
                .resize(450,250)
                .into(video.thumbImageView)


        getSystemService(Context.SENSOR_SERVICE)

        iv_bottom_bg.setImageURI(Uri.parse(movies.blurred))
        tv_video_title.setText(movies.title)
        tv_video_time.setText(movies.category)
        tv_video_desc.setText(movies.description)
        tv_video_favor.setText(movies.collectionCont)
        tv_video_share.setText(movies.replyCount)
        tv_video_reply.setText(movies.shareCount)
        tv_video_download.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(this@DetailsActivity,"别点我了",Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(JZVideoPlayer.backPress()){
            return
        }
    }

    override fun onPause() {
        super.onPause()
        JZVideoPlayer.releaseAllVideos()
    }
}



