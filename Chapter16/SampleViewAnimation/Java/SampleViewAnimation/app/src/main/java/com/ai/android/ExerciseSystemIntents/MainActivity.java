package com.ai.android.ExerciseSystemIntents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        handleMenus(item);
        return true;
    }

    private void handleMenus(MenuItem item) {
        appendMenuItemText(item);
        switch (item.getItemId()) {
            case R.id.menu_clear:
                emptyText();
                break;

            case R.id.menu_list_animation:
                Intent intent = new Intent(this, ViewAnimationActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void appendMenuItemText(MenuItem item) {
        String title = item.getTitle().toString();
        TextView tv = findViewById(R.id.textViewId);
        tv.setText(String.format("%s\n%s:%d", tv.getText(), title, item.getItemId()));
    }

    private void emptyText() {
        TextView tv = findViewById(R.id.textViewId);
        tv.setText("");
    }
}