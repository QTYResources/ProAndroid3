package com.androidbook.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

public class AlarmIntentPrimacyTester extends ScheduleIntentMultipleTimesTester {

    private static final String TAG = AlarmIntentPrimacyTester.class.getSimpleName();

    public AlarmIntentPrimacyTester(Context ctx, IReportBack target) {
        super(ctx, target);
    }

    /**
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
    public void alarmIntentPrimacy() {
        Calendar cal = Utils.getTimeAfterInSecs(30);
        String s = Utils.getDateTimeString(cal);
        mReportTo.reportBack(TAG, "Schdeduling Repeating alarm in 5 sec interval starting at: " + s);

        // Get an intent to invoke
        // TestReceiver class
        Intent intent = new Intent(mContext, TestReceiver.class);
        intent.putExtra("message", "Repeating Alarm");

        PendingIntent pi = getDistinctPendingIntent(intent, 0);
        AlarmManager am = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 5 * 1000, pi);

        mReportTo.reportBack(TAG, "Setting a onetime alarm on the same intent");
        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);
        mReportTo.reportBack(TAG, "The later alarm, one time one, takes precedence");
    }
}
