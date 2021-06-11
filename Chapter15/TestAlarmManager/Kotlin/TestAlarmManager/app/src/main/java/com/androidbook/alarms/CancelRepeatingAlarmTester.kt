package com.androidbook.alarms

import android.app.AlarmManager
import android.content.Context
import android.content.Intent

open class CancelRepeatingAlarmTester(
    ctx: Context,
    target: IReportBack
): SendRepeatingAlarmTester(ctx, target) {

    /*
	 * An alarm can be stopped by canceling the intent.
	 * You will need to have a copy of the intent
	 * to cancel it.
	 *
	 * The intent needs to have the same signature
	 * and request id.
	 */
    fun cancelRepeatingAlarm() {
        //Get an intent to invoke
        //TestReceiver class
        val intent = Intent(mContext, TestReceiver::class.java)

        //To cancel, extra is not necessary to be filled in
        //intent.putExtra("message", "Repeating Alarm");

        val pi = getDistinctPendingIntent(intent, 2)

        // Schedule the alarm!
        val am = mContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        am.cancel(pi)
        mReportTo.reportBack(TAG, "You shouldn't see alarms again")
    }

    companion object {
        const val TAG = "CancelRepeatingAlarmTester"
    }
}