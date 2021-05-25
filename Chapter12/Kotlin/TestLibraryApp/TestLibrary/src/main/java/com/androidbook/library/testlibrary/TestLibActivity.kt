package com.androidbook.library.testlibrary

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class TestLibActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lib_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.lib_main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        appendMenuItemText(item)
        if (item.itemId == R.id.menu_clear) {
            emptyText()
        }
        return true
    }

    @SuppressLint("WrongViewCast")
    private fun getTextView(): TextView {
        return findViewById(R.id.text1)
    }

    @SuppressLint("SetTextI18n")
    private fun appendText(abc: String) {
        val tv = getTextView()
        tv.text = "${tv.text}\n$abc"
    }

    @SuppressLint("SetTextI18n")
    private fun appendMenuItemText(menuItem: MenuItem) {
        val title = menuItem.title.toString()
        val tv = getTextView()
        tv.text = "${tv.text}\n$title"
    }

    private fun emptyText() {
        val tv = getTextView()
        tv.text = ""
    }

    companion object {
        const val TAG = "TestLibActivity"
    }
}