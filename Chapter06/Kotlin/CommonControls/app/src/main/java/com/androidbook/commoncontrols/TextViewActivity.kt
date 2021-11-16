package com.androidbook.commoncontrols

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class TextViewActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.textview)

        val tv = findViewById<TextView>(R.id.tv)
        val et = findViewById<EditText>(R.id.et)
        val actv = findViewById<AutoCompleteTextView>(R.id.actv)

        val aa = ArrayAdapter<String>(this,
            android.R.layout.simple_dropdown_item_1line,
            arrayOf("English", "Hebrew", "Hindi", "Spanish", "German", "Greek")
        )

        actv.setAdapter(aa)

        val mactv = findViewById<MultiAutoCompleteTextView>(R.id.mactv)
        val aa2 = ArrayAdapter<String>(this,
            android.R.layout.simple_dropdown_item_1line,
            arrayOf("English", "Hebrew", "Hindi", "Spanish", "German", "Greek")
        )

        mactv.setAdapter(aa2)

        mactv.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
    }
}