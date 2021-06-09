package com.ai.android.ExerciseSystemIntents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ViewAnimationActivity extends AppCompatActivity {

    private static final String TAG = ViewAnimationActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        setupListView();
        setupButton();
    }

    private void setupListView() {
        String[] listItems = new String[] {
                "Item 1", "Item 2", "Item 3",
                "Item 4", "Item 5", "Item 6"
        };

        ArrayAdapter<String> listItemAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        ListView lv = findViewById(R.id.list_view_id);
        lv.setAdapter(listItemAdapter);
    }

    private void setupButton() {
        Button b = findViewById(R.id.btn_animate);
        b.setOnClickListener((v) -> animateListView());
    }

    private void animateListView() {
        Log.d(TAG, "animate list view");
        ListView lv = findViewById(R.id.list_view_id);
        float cx = (float)(lv.getWidth() / 2.0);
        float cy = (float)(lv.getHeight() / 2.0);
        lv.startAnimation(new ViewAnimation1(cx, cy));
    }
}