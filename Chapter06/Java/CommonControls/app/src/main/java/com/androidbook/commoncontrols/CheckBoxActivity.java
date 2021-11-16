package com.androidbook.commoncontrols;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import androidx.activity.ComponentActivity;

public class CheckBoxActivity extends ComponentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox);

        CheckBox fishCB = findViewById(R.id.fishCB);

        if (fishCB.isChecked()) {
            fishCB.toggle();        // flips the checkbox to unchecked if it was checked
        }

        fishCB.setOnCheckedChangeListener((arg0, isChecked) -> {
            Log.v("CheckBoxActivity", "The fish checkbox is now "
                    + (isChecked ? "checked" : "not checked"));
        });
    }

    public void doClick(View view) {
        Log.v("CheckBoxActivity", "The steak checkbox is now " +
                (((CheckBox) view).isChecked() ? "checked" : "not checked"));
    }
}
