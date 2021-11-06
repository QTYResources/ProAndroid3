package com.ai.android.book.resources

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

open abstract class MonitoredDebugActivity: MonitoredActivity, IReportBack {

    // Derived classes needs first
    protected abstract fun onMenuItemSelected(item: MenuItem): Boolean;

    // private variables set by constructor
    private var menuId: Int = 0
    private var m_retainState: Boolean = false

    constructor(inMenuId: Int, inTag: String) : super(inTag) {
        tag = inTag
        menuId = inMenuId
    }

    public fun retainState() {
        m_retainState = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.debug_activity_layout);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(menuId, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_da_clear -> {
                emptyText()
                true
            }
            else -> onMenuItemSelected(item)
        }
    }

    @SuppressLint("WrongViewCast")
    protected fun getTextView(): TextView {
        return findViewById(R.id.text1)
    }

    protected fun appendMenuItemText(menuItem: MenuItem) {
        val title = menuItem.title.toString()
        val tv = getTextView()
        tv.text = "${tv.text}\n$title"
    }

    protected fun emptyText() {
        val tv = getTextView()
        tv.text = ""
        tv.setBackgroundDrawable(null)
        tv.setBackgroundColor(resources.getColor(android.R.color.white))
    }

    private fun appendText(s: String) {
        val tv = getTextView()
        tv.text = "${tv.text}\n$s"
        Log.d(tag, s)
    }

    override fun reportBack(tag: String, message: String) {
        appendText("$tag:$message")
        Log.d(tag, message)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val st = savedInstanceState.getString("debugViewText") ?: return
        val tv = getTextView()
        tv.text = st
        Log.d(tag, "Restored state")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (!m_retainState) return

        // save state
        val tv = getTextView()
        val t = tv.text.toString()
        outState.putString("debugViewText", t)
        Log.d(tag, "Saved state")
    }

    companion object {
        var tag: String? = null
    }
}