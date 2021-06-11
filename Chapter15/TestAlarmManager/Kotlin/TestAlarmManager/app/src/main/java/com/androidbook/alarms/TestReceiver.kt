package com.androidbook.alarms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class TestReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Utils.logThreadSignature()
        Log.d(TAG, "intent=$intent")
        val message = intent.getStringExtra("message")
        Log.d(TAG, message ?: "")
    }

    companion object {
        const val TAG = "TestReceiver"
    }
}