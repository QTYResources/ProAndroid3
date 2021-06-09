package com.ai.android.sampleviewanimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        handleMenus(item)
        return true
    }

    private fun handleMenus(item: MenuItem) {
        appendMenuItemText(item)
        when (item.itemId) {
            R.id.menu_clear -> emptyText()
            R.id.menu_list_animation -> {
                val intent = Intent(this, ViewAnimationActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun appendMenuItemText(item: MenuItem) {
        val tv = findViewById<TextView>(R.id.textViewId)
        tv.text = String.format("%s\n%s:%d", tv.text, item.title, item.itemId)
    }

    private fun emptyText() {
        val tv = findViewById<TextView>(R.id.textViewId)
        tv.text = ""
    }

    companion object {
        const val TAG = "MainActivity"
    }
}