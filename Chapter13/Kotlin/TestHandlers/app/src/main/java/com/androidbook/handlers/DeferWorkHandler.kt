package com.androidbook.handlers

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log

open class DeferWorkHandler(
    private val parentActivity: TestHandlersDriverActivity,
    loop: Looper,
    private var count: Int = 0,
) : Handler(loop) {

    override fun handleMessage(msg: Message) {
        val pm = "message called:$count:${msg.data.getString("message")}"

        Log.d(TAG, pm)
        printMessage(pm)

        if (count > 5) return

        count++
        sendTestMessage(1)
    }

    private fun sendTestMessage(interval: Long) {
        val m = obtainMessage()
        prepareMessage(m)
        sendMessageDelayed(m, interval * 1000)
    }

    open fun doDeferredWork() {
        count = 0
        sendTestMessage(1)
    }

    private fun prepareMessage(m: Message) {
        val b = Bundle()
        b.putString("message", "Hello world")
        m.data = b
    }

    private fun printMessage(xyz: String) {
        parentActivity.appendText(xyz)
    }

    companion object {
        const val TAG = "TestHandler1"
    }
}