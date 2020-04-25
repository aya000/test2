package com.test.playaudiopractice

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMediaPlayer()


        playBtn.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        }

        pauseBtn.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        }

        stopBtn.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.reset()
            }
            initMediaPlayer()
        }

        videoBtn.setOnClickListener {

            //去播放视频
            VideoActivity.actionStart(this)
        }
    }

    private fun initMediaPlayer() {
        val assetsManager = assets
        val assetFileDescriptor = assetsManager.openFd("music.mp3")

        mediaPlayer.setDataSource(
            assetFileDescriptor.fileDescriptor,
            assetFileDescriptor.startOffset,
            assetFileDescriptor.length
        )
        mediaPlayer.prepare()
    }

    override fun onDestroy() {
        super.onDestroy()
        //释放资源
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}
