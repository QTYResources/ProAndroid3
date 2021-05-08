package com.androidbook.preferences.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FlightPreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_preferences_activity);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings_container, new FlightPreferenceFragment())
                .commit();
    }
}