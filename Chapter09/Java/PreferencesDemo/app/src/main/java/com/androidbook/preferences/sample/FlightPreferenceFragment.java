package com.androidbook.preferences.sample;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class FlightPreferenceFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.flightoptions, rootKey);
    }
}