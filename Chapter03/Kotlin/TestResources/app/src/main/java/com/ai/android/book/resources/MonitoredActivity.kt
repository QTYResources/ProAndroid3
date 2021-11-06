package com.ai.android.book.resources

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class MonitoredActivity(): AppCompatActivity() {

    private var tag: String? = null

    constructor(intag: String): this() {
        this.tag = intag
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause. I may be partially or fully invisible");
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop. I am fully invisible");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy. about to be removed");
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart. UI controls are there.");
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart. UI may be partially visible.");
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume. UI fully visible.");
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(tag, "onRestoreInstanceState. You should restore state");
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(tag, "onSaveInstanceState. You should load up the bundle");
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d(tag, "onConfigurationChanged.");
    }
}