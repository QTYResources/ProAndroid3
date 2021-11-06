package com.ai.android.book.provider

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class MonitoredActivity(
    intag: String
): AppCompatActivity() {

    init {
        TAG = intag
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate.")
        super.onCreate(savedInstanceState)
    }

    override fun onPause() {
        Log.d(TAG, "onPause. I may be partially or fully invisible")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop. I am fully invisible")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy. about to be removed")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart. UI controls are there.")
        super.onRestart()
    }

    override fun onStart() {
        Log.d(TAG, "onStart. UI may be partially visible.")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume. UI fully visible.")
        super.onResume()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState. You should restore state")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState. You should load up the bundle")
        super.onSaveInstanceState(outState)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        Log.d(TAG, "onConfigurationChanged.")
        super.onConfigurationChanged(newConfig)
    }

    companion object {
        var TAG: String? = null
    }
}