package com.androidbook.preferences.sample

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class FlightPreferenceFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.flightoptions, rootKey)
    }
}