package com.androidbook.library.testlibraryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.androidbook.library.testlibrary.TestLibActivity;

public class TestAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        appendMenuItemText(item);
        switch (item.getItemId()) {
            case R.id.menu_clear:
                emptyText();
                break;

            case R.id.menu_library_activity:
                invokeLibActivity(item.getItemId());
                break;
        }
        return true;
    }

    private void invokeLibActivity(int mid) {
        Intent intent = new Intent(this, TestLibActivity.class);
        intent.putExtra("com.ai.menuid", mid);
        startActivity(intent);
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