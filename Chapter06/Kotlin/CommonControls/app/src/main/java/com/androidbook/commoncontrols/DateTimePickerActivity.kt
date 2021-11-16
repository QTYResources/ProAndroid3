package com.androidbook.commoncontrols

import android.os.Build
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class DateTimePickerActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.datetimepicker)

        val dateDefault = findViewById<TextView>(R.id.dateDefault)
        val timeDefault = findViewById<TextView>(R.id.timeDefault)

        val dp = findViewById<DatePicker>(R.id.datePicker)
        // The month, and just the month, is zero-based. Add 1 for display.
        dateDefault.text = "Date defaulted to ${dp.month + 1}/${dp.dayOfMonth}/${dp.year}"
        // And here, subtract 1 from December (12) to set it to December
        dp.init(2008, 11, 10, null)

<<<<<<< HEAD
        val tp = findViewById<TimePicker>(R.id.timePicker)

        val timeF = Formatter()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            timeF.format("Time defaulted to %d:%02d", tp.hour, tp.minute)
        } else {
            timeF.format("Time defaulted to %d:%02d", tp.currentHour, tp.currentMinute)
        }
        timeDefault.text = timeF.toString()

        tp.setIs24HourView(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            tp.hour = 10
            tp.minute = 10
        } else {
            tp.currentHour = 10
            tp.currentMinute = 10
        }
=======
val tp = findViewById<TimePicker>(R.id.timePicker)

val timeF = Formatter()
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    timeF.format("Time defaulted to %d:%02d", tp.hour, tp.minute)
} else {
    timeF.format("Time defaulted to %d:%02d", tp.currentHour, tp.currentMinute)
}
timeDefault.text = timeF.toString()

tp.setIs24HourView(true)
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    tp.hour = 10
    tp.minute = 10
} else {
    tp.currentHour = 10
    tp.currentMinute = 10
}
>>>>>>> afbbc0f (添加第6章源代码)

    }
}