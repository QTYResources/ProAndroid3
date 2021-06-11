package com.androidbook.alarms

import android.util.Log
import java.lang.RuntimeException
import java.text.SimpleDateFormat
import java.util.*

class Utils {

    companion object {
        fun getThreadId(): Long {
            val t = Thread.currentThread()
            return t.id
        }

        fun getThreadSignature(): String {
            val t = Thread.currentThread()
            val tg = t.threadGroup
            return "${t.name}:(id)${t.id}:(priority)${t.priority}:(group)${tg?.name ?: "unknown"}"
        }

        fun logThreadSignature() {
            Log.d("ThreadUtils", getThreadSignature())
        }

        fun sleepForInSecs(secs: Int) {
            try {
                Thread.sleep(secs * 1000L)
            } catch (e: InterruptedException) {
                throw RuntimeException("interrupted", e)
            }
        }

        fun getTimeAfterInSecs(secs: Int): Calendar {
            val cal = Calendar.getInstance()
            cal.add(Calendar.SECOND, secs)
            return cal
        }

        fun getCurrentTime(): Calendar {
            return Calendar.getInstance()
        }

        fun getTodayAt(hours: Int): Calendar {
            val today = Calendar.getInstance()
            val cal = Calendar.getInstance()
            cal.clear()

            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            // represents the day of the month
            val day = today.get(Calendar.DATE)
            cal.set(year, month, day, hours, 0, 0)
            return cal
        }

        fun getDateTimeString(cal: Calendar): String {
            val sdf = SimpleDateFormat("MM/dd/yyyy hh:mm:ss")
            sdf.isLenient = false
            return sdf.format(cal.time)
        }
    }
}