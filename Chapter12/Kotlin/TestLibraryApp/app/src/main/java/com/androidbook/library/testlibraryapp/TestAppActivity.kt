package com.androidbook.library.testlibraryapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.androidbook.library.testlibrary.TestLibActivity

class TestAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        appendMenuItemText(item)
        when (item.itemId) {
            R.id.menu_clear -> emptyText()
            R.id.menu_library_activity -> invokeLibActivity(item.itemId)
        }
        return true
    }

    private fun invokeLibActivity(mid: Int) {
        val intent = Intent(this, TestLibActivity::class.java)
        intent.putExtra("com.ai.menuid", mid)
        startActivity(intent)
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
        const val TAG = "TestAppActivity"
    }
}