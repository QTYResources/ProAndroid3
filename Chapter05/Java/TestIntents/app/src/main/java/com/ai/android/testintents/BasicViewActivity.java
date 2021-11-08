package com.ai.android.testintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BasicViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_view);
    }
}