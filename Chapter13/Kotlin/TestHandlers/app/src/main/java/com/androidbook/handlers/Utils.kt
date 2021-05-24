package com.androidbook.handlers

import android.os.Bundle
import android.util.Log
import java.lang.RuntimeException

class Utils {

    companion object {

        fun getThreadId(): Long {
            val t = Thread.currentThread()
            return t.id
        }

        fun getThreadSignature(): String {
            val t = Thread.currentThread()
            var gname: String? = t.threadGroup?.name
            return "${t.name}:(id)${t.id}:(priority)${t.priority}:(group)${gname ?: "null"}"
        }

        fun logThreadSignature() {
            Log.d("ThreadUtils", getThreadSignature())
        }

        fun sleepForInSecs(secs: Int) {
            try {
                Thread.sleep(secs * 1000L)
            } catch (x: InterruptedException) {
                throw RuntimeException("interrupted", x)
            }
        }

        fun getStringAsABundle(message: String): Bundle {
            val b = Bundle()
            b.putString("message", message)
            return b
        }

        fun getStringFromABundle(b: Bundle): String? {
            return b.getString("message")
        }

    }
}