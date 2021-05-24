package com.androidbook.handlers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class TestHandlersDriverActivity extends AppCompatActivity {

    private static final String TAG = "DriverActivity";

    private DeferWorkHandler th = null;
    private Handler statusBackHandler = null;
    private Thread workerThread = null;

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

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        appendMenuItemText(item);
        switch (item.getItemId()) {
            case R.id.menu_clear:
                emptyText();
                break;

            case R.id.menu_test_thread:
                testThread();
                break;

            case R.id.menu_test_defered_handler:
                testDeferedHandler();
                break;
        }
        return true;
    }

    private TextView getTextView() {
        return findViewById(R.id.text1);
    }

    public void appendText(String abc) {
        TextView tv = getTextView();
        tv.setText(String.format("%s\n%s", tv.getText(), abc));
    }

    private void appendMenuItemText(MenuItem menuItem) {
        String title = menuItem.getTitle().toString();
        TextView tv = getTextView();
        tv.setText(String.format("%s\n%s", tv.getText(), title));
    }

    private void emptyText() {
        TextView tv = getTextView();
        tv.setText("");
    }

    private void testDeferedHandler() {
        if (th == null) {
            th = new DeferWorkHandler(this);
            appendText("Starting to do deferred work by sending messages");
        }
        appendText("Starting to do deferred work by sending messages");
        th.doDeferredWork();
    }

    private void testThread() {
        if (statusBackHandler == null) {
            statusBackHandler = new ReportStatusHandler(this);
        }
        if (workerThread != null && workerThread.getState() != Thread.State.TERMINATED) {
            Log.d(TAG, "thread is new or alive, but not terminated");
        } else {
            Log.d(TAG, "thread is likely dead. starting now");
            // you have to create a new thread.
            // no way to resurrect a dead thread.
            workerThread = new Thread(new WorkerThreadRunnable(statusBackHandler));
            workerThread.start();
        }
    }
}