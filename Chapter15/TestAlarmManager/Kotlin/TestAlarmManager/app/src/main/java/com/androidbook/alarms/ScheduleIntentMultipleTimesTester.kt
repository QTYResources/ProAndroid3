package com.androidbook.alarms

import android.app.AlarmManager
import android.content.Context
import android.content.Intent

open class ScheduleIntentMultipleTimesTester(
    ctx: Context,
    target: IReportBack
): CancelRepeatingAlarmTester(ctx, target) {

    /*
	 * Same intent cannot be scheduled multiple times.
	 * If you do, only the last one will take affect.
	 *
	 * Notice you are using the same request id.
	 */
    fun scheduleSameIntentMultipleTimes() {
        //Get the instance in time that is
        //30 secs from now.
        val cal = Utils.getTimeAfterInSecs(30)
        val cal2 = Utils.getTimeAfterInSecs(35)
        val cal3 = Utils.getTimeAfterInSecs(40)
        val cal4 = Utils.getTimeAfterInSecs(45)

        //If you want to point to 11:00 hours today.
        //Calendar cal = Utils.getTodayAt(11);

        //Print to the debug view that we are
        //scheduling at a specific time
        val s = Utils.getDateTimeString(cal)
        mReportTo.reportBack(TAG, "Schdeduling alarm at: $s")

        //Get an intent to invoke
        //TestReceiver class
        val intent = Intent(mContext, TestReceiver::class.java)
        intent.putExtra("message", "Single Shot Alarm")

        val pi = getDistinctPendingIntent(intent, 1)

        // Schedule the alarm!
        val am = mContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        am.set(AlarmManager.RTC_WAKEUP, cal.timeInMillis, pi)
        am.set(AlarmManager.RTC_WAKEUP, cal2.timeInMillis, pi)
        am.set(AlarmManager.RTC_WAKEUP, cal3.timeInMillis, pi)
        am.set(AlarmManager.RTC_WAKEUP, cal4.timeInMillis, pi)
    }

    /*
	 * Same intent can be scheduled multiple times
	 * if you change the request id on the pending intent.
	 * Request id identifies an intent as a unique intent.
	 */
    fun scheduleDistinctIntents() {
        //Get the instance in time that is
        //30 secs from now.
        val cal = Utils.getTimeAfterInSecs(30)
        val cal2 = Utils.getTimeAfterInSecs(35)
        val cal3 = Utils.getTimeAfterInSecs(40)
        val cal4 = Utils.getTimeAfterInSecs(45)

        //If you want to point to 11:00 hours today.
        //Calendar cal = Utils.getTodayAt(11);

        //Print to the debug view that we are
        //scheduling at a specific time
        val s = Utils.getDateTimeString(cal)
        mReportTo.reportBack(TAG, "Schdeduling alarm at: $s")

        //Get an intent to invoke
        //TestReceiver class
        val intent = Intent(mContext, TestReceiver::class.java)
        intent.putExtra("message", "Single Shot Alarm")

        // Schedule the alarm!
        val am = mContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        am.set(AlarmManager.RTC_WAKEUP, cal.timeInMillis, getDistinctPendingIntent(intent, 1))
        am.set(AlarmManager.RTC_WAKEUP, cal2.timeInMillis, getDistinctPendingIntent(intent, 1))
        am.set(AlarmManager.RTC_WAKEUP, cal3.timeInMillis, getDistinctPendingIntent(intent, 1))
        am.set(AlarmManager.RTC_WAKEUP, cal4.timeInMillis, getDistinctPendingIntent(intent, 1))
    }

    companion object {
        const val TAG = "ScheduleIntentMultipleTimesTester"
    }
}