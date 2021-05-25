package com.androidbook.library.testlibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class TestLibActivity extends AppCompatActivity {

    private static final String TAG = "TestLibActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lib_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.lib_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        appendMenuItemText(item);
        if (item.getItemId() == R.id.menu_clear) {
            emptyText();
        }
        return true;
    }

    private TextView getTextView() {
        return findViewById(R.id.text1);
    }

    private void appendText(String abc) {
        TextView tv = getTextView();
        tv.setText(tv.getText() + "\n" + abc);
    }

    private void appendMenuItemText(MenuItem menuItem) {
        String title = menuItem.getTitle().toString();
        TextView tv = getTextView();
        tv.setText(tv.getText() + "\n" + title);
    }

    private void emptyText() {
        TextView tv = getTextView();
        tv.setText("");
    }
}