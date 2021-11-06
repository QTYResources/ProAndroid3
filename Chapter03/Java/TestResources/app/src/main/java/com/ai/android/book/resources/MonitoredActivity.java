package com.ai.android.book.resources;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class MonitoredActivity extends AppCompatActivity {

    private String tag = null;

    protected MonitoredActivity(String intag) {
        tag = intag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(tag, "onCreate.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "onPause. I may be partially or fully invisible");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "onStop. I am fully invisible");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "onDestroy. about to be removed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "onRestart. UI controls are there.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "onStart. UI may be partially visible.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "onResume. UI fully visible.");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(tag, "onRestoreInstanceState. You should restore state");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(tag, "onSaveInstanceState. Yout should load up the bundle");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(tag, "onConfigurationChanged.");
    }
}