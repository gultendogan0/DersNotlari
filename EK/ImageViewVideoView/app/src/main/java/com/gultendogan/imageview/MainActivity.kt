package com.gultendogan.imageview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //IMAGEVIEW
        buttonAndroid.setOnClickListener {

            imageView.setImageResource(R.drawable.image_android)
        }

        buttonEmoji.setOnClickListener {
            imageView.setImageResource(resources.getIdentifier("image_emoji","drawable",packageName))
        }


        //VIDEOVIEW
        buttonStart.setOnClickListener {
            val address = Uri.parse("android.resource://"+packageName+"/"+R.raw.videoplayback)
            videoView.setVideoURI(address)
            videoView.start()
        }

        buttonStop.setOnClickListener {
            videoView.stopPlayback()
        }

    }
}