package com.ai.android.book.provider

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

abstract class MonitoredDebugActivity(
    private val menuId: Int,
    inTag: String
): MonitoredActivity(inTag) {

    // Derived classes needs first
    protected abstract fun onMenuItemSelected(item: MenuItem): Boolean

    private var m_retainState = false

    init {
        TAG = inTag
    }

    fun retainState() {
        m_retainState = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(menuId, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        appendMenuItemText(item)
        return when (item.itemId) {
            R.id.menu_da_clear -> {
                emptyText()
                true
            }
            else -> onMenuItemSelected(item)
        }
    }

    @SuppressLint("WrongViewCast")
    private fun getTextView(): TextView {
        return findViewById(R.id.text1)
    }

    private fun appendMenuItemText(menuItem: MenuItem) {
        val tv = getTextView()
        tv.text = String.format("%s\n%s", tv.text, menuItem.title)
    }

    private fun emptyText() {
        getTextView().text = ""
    }

    private fun appendText(s: String) {
        val tv = getTextView()
        tv.text = String.format("%s\n%s", tv.text, s)
    }

    open fun reportBack(tag: String, message: String) {
        appendText("$tag:$message")
        Log.d(TAG, message)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val st = savedInstanceState.getString("debugViewText") ?: return
        val tv = getTextView()
        tv.text = st
        Log.d(TAG, "Restored state")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (!m_retainState) return

        // save state
        outState.putString("debugViewText", getTextView().text.toString())
        Log.d(TAG, "Saved state")
    }

    companion object {
        var TAG: String? = null
    }
}