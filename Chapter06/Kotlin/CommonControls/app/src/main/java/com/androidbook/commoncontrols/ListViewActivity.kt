package com.androidbook.commoncontrols

import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity

class ListViewActivity: AppCompatActivity() {

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
            c, cols, views)

        listView.adapter = adapter
    }
}