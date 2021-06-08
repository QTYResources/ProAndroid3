package com.ai.android.frameanimation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class FrameAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_animations_layout)
        setupButton()
    }

    private fun setupButton() {
        val b = findViewById<Button>(R.id.startFAButtonId)
        b.setOnClickListener { parentButtonClicked() }
    }

    private fun parentButtonClicked() {
        animate()
    }

    private fun animate() {
        val imgView = findViewById<ImageView>(R.id.imageView)
        imgView.visibility = ImageView.VISIBLE
        imgView.setBackgroundResource(R.drawable.frame_animation)

        val frameAnimation = imgView.background as AnimationDrawable
        if (frameAnimation.isRunning) {
            frameAnimation.stop()
        } else {
            frameAnimation.stop()
            frameAnimation.start()
        }
    }

}