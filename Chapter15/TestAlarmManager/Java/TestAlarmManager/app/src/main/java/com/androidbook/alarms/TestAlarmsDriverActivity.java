package com.androidbook.alarms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class TestAlarmsDriverActivity extends AppCompatActivity implements IReportBack {

    private static final String TAG = TestAlarmsDriverActivity.class.getSimpleName();

//    private SendAlarmOnceTester alarmTester = null;
//    private SendRepeatingAlarmTester alarmTester = null;
//    private CancelRepeatingAlarmTester alarmTester = null;
//    private ScheduleIntentMultipleTimesTester alarmTester = null;
    private AlarmIntentPrimacyTester alarmTester = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmTester = new AlarmIntentPrimacyTester(this, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();  // from activity
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        appendMenuItemText(item);
        switch (item.getItemId()) {
            case R.id.menu_clear:
                emptyText();
                break;

            case R.id.menu_alarm_once:
                alarmTester.sendAlarmOnce();
                break;

            case R.id.menu_alarm_repeated:
                alarmTester.sendRepeatingAlarm();
                break;

            case R.id.menu_alarm_cancel:
                alarmTester.cancelRepeatingAlarm();
                break;

            case R.id.menu_alarm_multiple:
                alarmTester.scheduleSameIntentMultipleTimes();
                break;

            case R.id.menu_alarm_distinct_intents:
                alarmTester.scheduleDistinctIntents();
                break;

            case R.id.menu_alarm_intent_primacy:
                alarmTester.alarmIntentPrimacy();
                break;
        }
        return true;
    }

    private TextView getTextView() {
        return findViewById(R.id.text1);
    }

    private void appendMenuItemText(MenuItem item) {
        String title = item.getTitle().toString();
        TextView tv = getTextView();
        tv.setText(String.format("%s\n%s", tv.getText(), title));
    }

    private void emptyText() {
        TextView tv = getTextView();
        tv.setText("");
    }

    private void appendText(String s) {
        TextView tv = getTextView();
        tv.setText(String.format("%s\n%s", tv.getText(), s));
        Log.d(TAG, s);
    }

    @Override
    public void reportBack(String tag, String message) {
        appendText(tag + ":" + message);
        Log.d(TAG, message);
    }
}