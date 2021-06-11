package com.androidbook.alarms

import android.app.AlarmManager
import android.content.Context
import android.content.Intent

open class AlarmIntentPrimacyTester(
    ctx: Context,
    target: IReportBack
): ScheduleIntentMultipleTimesTester(ctx, target) {

    /*
	 * It is not the alarm that matters
	 * but the pending intent.
	 * Even with a repeating alarm for an intent,
	 * if you schedule the same intent again
	 * for one time, the later one takes affect.
	 *
	 * It is as if you are setting the
	 * alarm on an existing intent multiple
	 * times and not the other way around.
	 */
    fun alarmIntentPrimacy() {
        val cal = Utils.getTimeAfterInSecs(30)
        val s = Utils.getDateTimeString(cal)
        mReportTo.reportBack(TAG, "Schdeduling Repeating alarm in 5 sec interval starting at: $s")

        //Get an intent to invoke
        //TestReceiver class
        val intent = Intent(mContext, TestReceiver::class.java)
        intent.putExtra("message", "Repeating Alarm")

        val pi = getDistinctPendingIntent(intent, 0)
        val am = mContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        am.setRepeating(AlarmManager.RTC_WAKEUP, cal.timeInMillis, 5 * 1000, pi)

        mReportTo.reportBack(TAG, "Setting a onetime alarm on the same intent")
        am.set(AlarmManager.RTC_WAKEUP, cal.timeInMillis, pi)
        mReportTo.reportBack(TAG, "The late alarm, one time one, takes precedence")
    }

    companion object {
        const val TAG = "AlarmIntentPrimacyTester"
    }
}