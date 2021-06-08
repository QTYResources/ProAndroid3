package com.ai.android.SampleLayoutAnimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class LayoutAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_layout)
        setupListView()
    }

    private fun setupListView() {
        val listItems = arrayListOf<String>(
            "Item 1", "Item 2", "Item 3",
            "Item 4", "Item 5", "Item 6"
        )
        val listItemAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems)
        val lv = findViewById<ListView>(R.id.list_view_id)
        lv.adapter = listItemAdapter
    }

}