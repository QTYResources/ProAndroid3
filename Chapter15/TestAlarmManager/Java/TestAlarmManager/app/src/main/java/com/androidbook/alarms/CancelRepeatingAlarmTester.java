package com.androidbook.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class CancelRepeatingAlarmTester extends SendRepeatingAlarmTester {

    private static final String TAG = "CancelRepeatingAlarmTester";

    public CancelRepeatingAlarmTester(Context ctx, IReportBack target) {
        super(ctx, target);
    }

    /**
     * An alarm can be stopped by canceling the intent.
     * You will need to have a copy of the intent
     * to cancel it.
     *
     * The intent needs to have the same signature
     * and request id.
     */
    public void cancelRepeatingAlarm() {
        // Get an intent to invoke
        // TestReceiver class
        Intent intent = new Intent(mContext, TestReceiver.class);

        // To cancel, extra is not necessary to be filled in
        // intent.putExtra("message", "Repeating Alarm");

        PendingIntent pi = getDistinctPendingIntent(intent, 2);

        // Schedule the alarm!
        AlarmManager am = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        am.cancel(pi);
        mReportTo.reportBack(TAG, "You shouldn't see alarms again");
    }
}
