package com.test.playaudiopractice

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : AppCompatActivity() {

    companion object {

        fun actionStart(context: Context) {
            val intent = Intent(context, VideoActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val uri = Uri.parse("android.resource://$packageName/${R.raw.video}")
        videoView.setVideoURI(uri)

        playBtn.setOnClickListener {
            if (!videoView.isPlaying) {
                videoView.start()
            }
        }

        pauseBtn.setOnClickListener {
            if (videoView.isPlaying) {
                videoView.pause()
            }
        }

        resumeBtn.setOnClickListener {
            if (videoView.isPlaying) {
                videoView.resume()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        videoView.suspend()
    }
}
