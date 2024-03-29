package com.ai.android.book.resources;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;

public abstract class MonitoredDebugActivity extends MonitoredActivity implements IReportBack {

    // Derived classes needs first
    protected abstract boolean onMenuItemSelected(MenuItem item);

    // private variables set by constructor
    private static String tag = null;
    private int menuId = 0;
    private boolean m_retainState = false;

    public MonitoredDebugActivity(int inMenuId, String inTag) {
        super(inTag);
        tag = inTag;
        menuId = inMenuId;
    }

    public void retainState() {
        m_retainState = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debug_activity_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(menuId, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        appendMenuItemText(item);
        if (item.getItemId() == R.id.menu_da_clear) {
            emptyText();
            return true;
        }
        return onMenuItemSelected(item);
    }

    protected TextView getTextView() {
        return findViewById(R.id.text1);
    }

    protected void appendMenuItemText(MenuItem menuItem) {
        String title = menuItem.getTitle().toString();
        TextView tv = getTextView();
        tv.setText(tv.getText() + "\n" + title);
    }

    protected void emptyText() {
        TextView tv = getTextView();
        tv.setText("");
    }

    private void appendText(String s) {
        TextView tv = getTextView();
        tv.setText(tv.getText() + "\n" + s);
        Log.d(tag, s);
    }

    @Override
    public void reportBack(String tag, String message) {
        appendText(tag + ":" + message);
        Log.d(tag, message);
    }

    // Implement save/restore

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String st = savedInstanceState.getString("debugViewText");
        if (st == null) return;
        TextView tv = getTextView();
        tv.setText(st);
        Log.d(tag, "Restored state");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (m_retainState == false) return;

        // save state
        TextView tv = getTextView();
        String t = tv.getText().toString();
        outState.putString("debugViewText", t);
        Log.d(tag, "Saved state");
    }
}
