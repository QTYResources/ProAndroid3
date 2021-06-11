package com.androidbook.alarms

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class TestAlarmsDriverActivity : AppCompatActivity(), IReportBack {

//    private lateinit var alarmTester: SendAlarmOnceTester
//    private lateinit var alarmTester: SendRepeatingAlarmTester
//    private lateinit var alarmTester: CancelRepeatingAlarmTester
//    private lateinit var alarmTester: ScheduleIntentMultipleTimesTester
    private lateinit var alarmTester: AlarmIntentPrimacyTester

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alarmTester = AlarmIntentPrimacyTester(this, this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        appendMenuItemText(item)
        when (item.itemId) {
            R.id.menu_clear -> emptyText()
            R.id.menu_alarm_once -> alarmTester.sendAlarmOnce()
            R.id.menu_alarm_repeated -> alarmTester.sendRepeatingAlarm()
            R.id.menu_alarm_cancel -> alarmTester.cancelRepeatingAlarm()
            R.id.menu_alarm_multiple -> alarmTester.scheduleSameIntentMultipleTimes()
            R.id.menu_alarm_distinct_intents -> alarmTester.scheduleDistinctIntents()
            R.id.menu_alarm_intent_primacy -> alarmTester.alarmIntentPrimacy()
        }
        return true
    }

    @SuppressLint("WrongViewCast")
    private fun getTextView(): TextView {
        return findViewById(R.id.text1)
    }

    private fun appendMenuItemText(item: MenuItem) {
        val tv = getTextView()
        tv.text = String.format("%s\n%s", tv.text, item.title)
    }

    private fun emptyText() {
        getTextView().text = ""
    }

    private fun appendText(s: String) {
        val tv = getTextView()
        tv.text = String.format("%s\n%s", tv.text, s)
    }

    override fun reportBack(tag: String, message: String) {
        appendText("$tag:$message")
        Log.d(tag, message)
    }

}