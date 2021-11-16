package com.androidbook.commoncontrols;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.ComponentActivity;

public class DateTimePickerActivity extends ComponentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datetimepicker);

        TextView dateDefault = findViewById(R.id.dateDefault);
        TextView timeDefault = findViewById(R.id.timeDefault);

        DatePicker dp = findViewById(R.id.datePicker);
        // The month, and just the month, is zero-based. Add 1 for display.
        dateDefault.setText("Date defaulted to " + (dp.getMonth() + 1) + "/" +
                dp.getDayOfMonth() + "/" + dp.getYear());
        // And here, subtract 1 from December (12) to set it to December
        dp.init(2008, 11, 10, null);

        TimePicker tp = findViewById(R.id.timePicker);

        java.util.Formatter timeF = new java.util.Formatter();
        timeF.format("Time defaulted to %d:%02d", tp.getCurrentHour(),
                tp.getCurrentMinute());
        timeDefault.setText(timeF.toString());

        tp.setIs24HourView(true);
        tp.setCurrentHour(10);
        tp.setCurrentMinute(10);
    }
}
