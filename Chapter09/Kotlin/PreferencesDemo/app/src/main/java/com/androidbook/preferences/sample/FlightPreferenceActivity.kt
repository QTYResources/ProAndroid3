package com.androidbook.preferences.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FlightPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_preference)
        supportFragmentManager.beginTransaction()
            .replace(R.id.settings_container, FlightPreferenceFragment())
            .commit()
    }
}