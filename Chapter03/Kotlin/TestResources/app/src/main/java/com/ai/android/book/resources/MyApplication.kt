package com.ai.android.book.resources

import android.app.Application
import android.content.res.Configuration
import android.util.Log

class MyApplication: Application(){

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d(tag, "configuration changed")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(tag, "onCreate")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Log.d(tag, "onLowMemory")
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(tag, "onTerminate")
    }

    companion object {
        const val tag = "MyAplication"
    }
}