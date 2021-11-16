package com.androidbook.commoncontrols

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.style.BackgroundColorSpan
import android.text.style.StyleSpan
import android.text.util.Linkify
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StylesActivity: AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.styles)

        val tv = findViewById<TextView>(R.id.tv)
        tv.autoLinkMask = Linkify.ALL
        tv.text = "Please visit http://www.androidbook.com or email me at davemac327@gmail.com."

        val tv3 = findViewById<TextView>(R.id.tv3)
        tv3.setText("Styling the content of a TextView dynamically", TextView.BufferType.SPANNABLE)
        val spn = tv3.text as Spannable
        spn.setSpan(BackgroundColorSpan(Color.RED), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spn.setSpan(StyleSpan(Typeface.BOLD_ITALIC), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        val et = findViewById<EditText>(R.id.et)
        et.setText("Styling the content of an EditText dynamically")
        val spn2 = et.text as Spannable
        spn2.setSpan(BackgroundColorSpan(Color.RED), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spn2.setSpan(StyleSpan(Typeface.BOLD_ITALIC), 0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}