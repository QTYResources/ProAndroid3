package com.ai.android.frameanimation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    // Initialize this in onCreateOptions
    Menu myMenu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        myMenu = menu;

        MenuInflater mi= getMenuInflater();
        mi.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        try {
            handleMenus(item);
        } catch (Throwable t) {
            Log.d(TAG, t.getMessage(), t);
            throw new RuntimeException("error", t);
        }
        // should return true if the menu item
        // is handled
        return true;

        // If it is not our menu item
        // let the base class handle it
        // return super.onOptionsItemSelected(item);
    }

    private void handleMenus(MenuItem item) {
        appendMenuItemText(item);
        switch (item.getItemId()) {
            case R.id.menu_clear:
                emptyText();
                break;

            case R.id.menu_list_animation:
                Intent intent = new Intent(this, FrameAnimationActivity.class);
                startActivity(intent);
        }
    }

    public void appendMenuItemText(MenuItem item) {
        String title = item.getTitle().toString();
        TextView tv = findViewById(R.id.textViewId);
        tv.setText(String.format("%s\n%s:%d", tv.getText(), title, item.getItemId()));
    }

    private void emptyText() {
        TextView tv = findViewById(R.id.textViewId);
        tv.setText("");
    }
}