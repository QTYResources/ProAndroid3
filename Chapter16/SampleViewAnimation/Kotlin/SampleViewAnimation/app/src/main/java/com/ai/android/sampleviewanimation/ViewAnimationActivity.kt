package com.ai.android.sampleviewanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class ViewAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_layout)
        setupListView()
        setupButton()
    }

    private fun setupListView() {
        val listItems = arrayListOf<String>(
            "Item 1", "Item 2", "Item 3",
            "Item 4", "Item 5", "Item 6"
        )

        val listItemAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems)
        val lv = findViewById<ListView>(R.id.list_view_id)
        lv.adapter = listItemAdapter
    }

    private fun setupButton() {
        val b = findViewById<Button>(R.id.btn_animate)
        b.setOnClickListener { animationListView() }
    }

    private fun animationListView() {
        Log.d(TAG, "animate list view")
        val lv = findViewById<ListView>(R.id.list_view_id)
        val cx = (lv.width / 2.0).toFloat()
        val cy = (lv.height / 2.0).toFloat()
        lv.startAnimation(ViewAnimation1(cx, cy))
    }

    companion object {
        const val TAG = "ViewAnimationActivity"
    }
}