package com.androidbook.commoncontrols

import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ImageViewActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.imageview)

        val imgView = findViewById<ImageView>(R.id.image3)

        imgView.setImageResource(R.drawable.icon)

        imgView.setImageBitmap(BitmapFactory.decodeResource(resources, R.drawable.manatee04))

        imgView.setImageDrawable(Drawable.createFromPath("/mnt/sdcard/dave2.jpg"))

        imgView.setImageURI(Uri.parse("file://mnt/sdcard/dave2.jpg"))
    }
}