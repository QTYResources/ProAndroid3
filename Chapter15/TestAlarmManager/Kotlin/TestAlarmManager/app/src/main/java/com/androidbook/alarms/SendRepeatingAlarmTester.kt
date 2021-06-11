package com.androidbook.alarms

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

open class SendRepeatingAlarmTester(
    ctx: Context,
    target: IReportBack
): SendAlarmOnceTester(ctx, target) {

    /*
	 * An alarm can invoke a broadcast request
	 * starting at a specified time and at
	 * regular intervals.
	 *
	 * Uses the same intent as above
	 * but a distinct request id to avoid conflicts
	 * with the single shot alarm above.
	 *
	 * Uses getDistinctPendingIntent() utility.
	 */
    fun sendRepeatingAlarm() {
        val cal = Utils.getTimeAfterInSecs(30)
        // Caleandar testcal = Utils.getTodayAt(11)
        val s = Utils.getDateTimeString(cal)
        mReportTo.reportBack(TAG, "Schdeduling Repeating alarm in 5 sec interval starting at: $s")

        //Get an intent to invoke
        //TestReceiver class
        val intent = Intent(mContext, TestReceiver::class.java)
        intent.putExtra("message", "Repeating Alarm")

        val pi = getDistinctPendingIntent(intent, 2)
        // Schedule the alarm!
        val am = mContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        am.setRepeating(AlarmManager.RTC_WAKEUP, cal.timeInMillis, 5 * 1000, pi)
    }

    fun getDistinctPendingIntent(intent: Intent, requestId: Int): PendingIntent {
        return PendingIntent.getBroadcast(
            mContext,   // context
            requestId,  // request id
            intent, // intent to be delivered
            0
        )
    }

    companion object {
        const val TAG = "SendRepeatingAlarmTester"
    }

}