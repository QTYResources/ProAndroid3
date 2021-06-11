package com.androidbook.alarms

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

open class SendAlarmOnceTester(
    ctx: Context,
    target: IReportBack
): BaseTester(ctx, target){

    /*
	 * An alarm can invoke a broadcast request
	 * at a specified time.
	 * The name of the broadcast receiver is explicitly
	 * specified in the intent.
	 */
    fun sendAlarmOnce() {
        //Get the instance in time that is
        //30 secs from now.
        val cal = Utils.getTimeAfterInSecs(30)

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

        val pi = PendingIntent.getBroadcast(
            mContext,   // context
            1,  // request id, used for disambiguating this intent
            intent, // intent to be delivered
            PendingIntent.FLAG_ONE_SHOT);   //pending intent flags
        // Schedule the alarm!
        val am = mContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        am.set(AlarmManager.RTC_WAKEUP, cal.timeInMillis, pi)
    }

    companion object {
        const val TAG = "SendAlarmOnceTester"
    }

}