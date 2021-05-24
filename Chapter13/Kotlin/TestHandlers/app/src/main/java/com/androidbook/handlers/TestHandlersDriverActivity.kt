package com.androidbook.handlers

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

open class TestHandlersDriverActivity : AppCompatActivity() {

    private var th: DeferWorkHandler? = null
    private var statusBackHandler: Handler? = null
    private var workerThread: Thread? = null

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
            R.id.menu_test_thread -> testThread()
            R.id.menu_test_defered_handler -> testDeferedHandler()
        }
        return true
    }

    @SuppressLint("WrongViewCast")
    private fun getTextView(): TextView {
        return findViewById(R.id.text1)
    }

    @SuppressLint("SetTextI18n")
    open fun appendText(abc: String) {
        val tv = getTextView()
        tv.text = "${tv.text}\n$abc"
    }

    @SuppressLint("SetTextI18n")
    private fun appendMenuItemText(menuItem: MenuItem) {
        val tv = getTextView()
        tv.text = "${tv.text}\n${menuItem.title}"
    }

    private fun emptyText() {
        val tv = getTextView()
        tv.text = ""
    }

    private fun testDeferedHandler() {
        if (th == null) {
            th = DeferWorkHandler(this, Looper.getMainLooper())
            appendText("Creating a new handler")
        }
        appendText("Starting to do deferred work by sending messages")
        th?.doDeferredWork()
    }

    private fun testThread() {
        if (statusBackHandler == null) {
            statusBackHandler = ReportStatusHandler(this, Looper.getMainLooper())
        }
        if (workerThread != null && workerThread?.state != Thread.State.TERMINATED) {
            Log.d(TAG, "thread is new or alive, but not terminated")
        } else {
            Log.d(TAG, "thread is likely dead. starting now")
            // you have to create a new thread.
            // no way to resurrect a dead thread.
            workerThread = Thread(WorkerThreadRunnable(statusBackHandler!!))
            workerThread?.start()
        }
    }

    companion object {
        const val TAG = "DriverActivity"
    }
}