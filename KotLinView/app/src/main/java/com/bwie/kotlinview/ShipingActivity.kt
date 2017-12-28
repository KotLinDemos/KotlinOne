package com.bwie.kotlinview

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_shiping.*
import tv.danmaku.ijk.media.player.IjkMediaPlayer
import tv.danmaku.ijk.media.widget.media.AndroidMediaController
import tv.danmaku.ijk.media.widget.media.IjkVideoView

class ShipingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shiping)

        IjkMediaPlayer.loadLibrariesOnce(null)
        IjkMediaPlayer.native_profileBegin("libijkplayer.so")
        var ship_ijkPlayer: IjkVideoView =findViewById(R.id.ship_ijkPlayer) as IjkVideoView
        val ship_descrpotion:TextView = findViewById(R.id.ship_descrpotion) as TextView
        
        val controller = AndroidMediaController(this, false)
        ship_ijkPlayer.setMediaController(controller)


        var playUrl=intent.getStringExtra("playUrl")
        var description=intent.getStringExtra("description")

       // val url = "https://wdl.wallstreetcn.com/41aae4d2-390a-48ff-9230-ee865552e72d"
        ship_ijkPlayer.setVideoURI(Uri.parse(playUrl))
        ship_ijkPlayer.start()
    }
    fun setOrientation(orientation:Int){
        if(orientation==ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
         }else{
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        }
     }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onPause() {
        super.onPause()
        ship_ijkPlayer.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        IjkMediaPlayer.native_profileEnd()
    }

    override fun onResume() {
        super.onResume()
        ship_ijkPlayer.resume()
    }
}