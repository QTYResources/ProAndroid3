package com.androidbook.commoncontrols

import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity

class ListViewActivity3: AppCompatActivity() {

    private lateinit var lv: ListView
    private var cursor: Cursor? = null

    private var idCol = -1
    private var nameCol = -1
    private var notesCol = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list)

        lv = findViewById(android.R.id.list)

        cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
            null, null, null, ContactsContract.Contacts.DISPLAY_NAME)

        val cols = arrayOf(ContactsContract.Contacts.DISPLAY_NAME)
        cursor?.let {
            idCol = it.getColumnIndex(ContactsContract.Contacts._ID)
            nameCol = it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
        }

        val views = intArrayOf(android.R.id.text1)

        val adapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_multiple_choice,
            cursor, cols, views
        )

        lv.adapter = adapter

        lv.choiceMode = ListView.CHOICE_MODE_MULTIPLE

    }

    public fun doClick(view: View) {
        val count = lv.count
        val viewItems = lv.checkedItemPositions
        for (i in 0..count) {
            if (viewItems[i]) {
//                val cw = lv.getItemAtPosition(i) as CursorWrapper
                cursor?.let {
                    it.moveToPosition(i)
                    val id = it.getLong(idCol)
                    val name = it.getString(nameCol)
                    Log.v(TAG, "$name is checked. Position = $i. Id = $id")
                }
            }
        }
    }

    companion object {
        const val TAG = "ListViewActivity3"
    }
}