package com.androidbook.handlers

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log

class ReportStatusHandler(
    private val parentActivity: TestHandlersDriverActivity,
    loop: Looper,
) : Handler(loop) {

    override fun handleMessage(msg: Message) {
        val pm = Utils.getStringFromABundle(msg.data)

        Log.d(TAG, pm ?: "null")
        printMessage(pm ?: "null")
    }

    private fun printMessage(xyz: String) {
        parentActivity.appendText(xyz)
    }

    companion object {
        const val TAG = "TestHandler2"
    }
}