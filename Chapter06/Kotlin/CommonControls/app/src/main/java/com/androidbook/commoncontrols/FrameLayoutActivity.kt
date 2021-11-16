package com.androidbook.commoncontrols

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class FrameLayoutActivity: AppCompatActivity() {

    private lateinit var one: ImageView
    private lateinit var two: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listing6_46)

        one = findViewById(R.id.oneImgView)
        two = findViewById(R.id.twoImgView)

        one.setOnClickListener {
            two.visibility = View.VISIBLE
            it.visibility = View.GONE
        }

        two.setOnClickListener {
            one.visibility = View.VISIBLE
            it.visibility = View.GONE
        }
    }
}