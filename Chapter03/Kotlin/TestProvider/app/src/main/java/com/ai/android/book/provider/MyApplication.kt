package com.ai.android.book.provider

import android.app.Application
import android.content.res.Configuration
import android.util.Log

class MyApplication: Application() {

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d(TAG, "configuration changed")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Log.d(TAG, "onLowMemory")
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "onTerminate")
    }

    companion object {
        const val TAG = "MyApplication"
    }
}