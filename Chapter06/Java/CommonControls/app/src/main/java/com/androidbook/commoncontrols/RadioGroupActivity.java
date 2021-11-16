package com.androidbook.commoncontrols;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import androidx.activity.ComponentActivity;

public class RadioGroupActivity extends ComponentActivity {
    protected static final String TAG = "RadioGroupActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiogroup);

        RadioGroup radGrp = findViewById(R.id.radGrp);

        int checkedRadioButtonID = radGrp.getCheckedRadioButtonId();

        radGrp.setOnCheckedChangeListener((arg0, id) -> {
            switch (id) {
                case -1:
                    Log.v(TAG, "Choices cleared!");
                    break;
                case R.id.chRBtn:
                    Log.v(TAG, "Chose Chicken");
                    break;
                case R.id.fishRBtn:
                    Log.v(TAG, "Chose Fish");
                    break;
                case R.id.stkRBtn:
                    Log.v(TAG, "Chose Steak");
                    break;
                default:
                    Log.v(TAG, "Huh?");
                    break;
            }
        });
    }
}
