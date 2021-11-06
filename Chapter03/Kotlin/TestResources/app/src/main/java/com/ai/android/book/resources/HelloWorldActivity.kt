package com.ai.android.book.resources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HelloWorldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val tv = findViewById<TextView>(R.id.text1)
        tv.text = "Try this text instead"
    }
}