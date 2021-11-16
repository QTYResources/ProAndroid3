package com.androidbook.commoncontrols

import android.content.ContentUris
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity

class ListViewActivity4: AppCompatActivity() {

    private lateinit var adapter: SimpleCursorAdapter
    private lateinit var lv: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list)

        lv = findViewById(android.R.id.list)

        val projection = arrayOf(
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME
        )

        val c = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
            null, null, null, ContactsContract.Contacts.DISPLAY_NAME)

        val cols = arrayOf(ContactsContract.Contacts.DISPLAY_NAME)
        val views = intArrayOf(android.R.id.text1)

        adapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_multiple_choice,
            c, cols, views
        )

        lv.adapter = adapter

        lv.choiceMode = ListView.CHOICE_MODE_MULTIPLE
    }

    public fun doClick(view: View?) {
        if(!adapter.hasStableIds()) {
            Log.v(TAG, "Data is not stable")
            return
        }
        val viewItems = lv.checkedItemIds
        for (i in viewItems.indices) {
            val selectedPerson = ContentUris.withAppendedId(
                ContactsContract.Contacts.CONTENT_URI, viewItems[i]
            )
            Log.v(TAG, "$selectedPerson is checked.")
        }
    }

    companion object {
        const val TAG = "ListViewActivity4"
    }
}