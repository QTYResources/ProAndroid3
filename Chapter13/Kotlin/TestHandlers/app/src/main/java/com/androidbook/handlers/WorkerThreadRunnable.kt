package com.androidbook.handlers

import android.os.Handler
import android.util.Log

class WorkerThreadRunnable(private val mainThreadHandler: Handler) : Runnable {

    override fun run() {
        Log.d(TAG, "start execution")
        informStart()
        for (i in 1..10) {
            Utils.sleepForInSecs(1)
            informMiddle(i)
        }
        informFinish()
    }

    private fun informMiddle(count: Int) {
        val m = mainThreadHandler.obtainMessage()
        m.data = Utils.getStringAsABundle("done:$count")
        mainThreadHandler.sendMessage(m)
    }

    private fun informStart() {
        val m = mainThreadHandler.obtainMessage()
        m.data = Utils.getStringAsABundle("starting run")
        mainThreadHandler.sendMessage(m)
    }

    private fun informFinish() {
        val m = mainThreadHandler.obtainMessage()
        m.data = Utils.getStringAsABundle("Finishing run")
        mainThreadHandler.sendMessage(m)
    }

    companion object {
        const val TAG = "TestRunnable"
    }
}