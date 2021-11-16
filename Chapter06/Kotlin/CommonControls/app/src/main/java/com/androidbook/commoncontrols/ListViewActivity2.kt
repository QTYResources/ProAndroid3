package com.androidbook.commoncontrols

import android.content.ContentUris
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ListViewActivity2: AppCompatActivity(), AdapterView.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview)

        val listView = findViewById<ListView>(android.R.id.list)

        val c = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
            null, null, null, ContactsContract.Contacts.DISPLAY_NAME)

        val cols = arrayOf(ContactsContract.Contacts.DISPLAY_NAME)
        val views = intArrayOf(android.R.id.text1)

        val adapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_1,
            c, cols, views
        )

        listView.adapter = adapter
        listView.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.v("ListViewActivity", "in onItemClick with ${(view as TextView).text}. Position = $position. Id = $id")
        val selectedPersion = ContentUris.withAppendedId(
            ContactsContract.Contacts.CONTENT_URI, id
        )
        val intent = Intent(Intent.ACTION_VIEW, selectedPersion)
        startActivity(intent)
    }
}