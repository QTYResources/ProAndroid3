package com.ai.android.testintents;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    // Initialize this in onCreateOptions
    private Menu myMenu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setupButton();
        setupEditText();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        myMenu = menu;
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        try {
            handleMenus(item);
        } catch(Exception e) {
            Log.d(TAG, e.getMessage(), e);
            throw new RuntimeException("error", e);
        }
        return true;
    }

    private void handleMenus(MenuItem item) {
        appendMenuItemText(item);
        switch (item.getItemId()) {
            case R.id.menu_clear:
                emptyText();
                break;

            case R.id.menu_basic_view:
                IntentsUtils.invokeBasicActivity(this);
                break;

            case R.id.menu_show_browser:
                IntentsUtils.invokeWebBrowser(this);
                break;

            case R.id.menu_search:
                IntentsUtils.invokeWebSearch(this);
                break;

            case R.id.menu_dial:
                IntentsUtils.dial(this);
                break;

            case R.id.menu_call:
                IntentsUtils.call(this);
                break;

            case R.id.menu_map:
                IntentsUtils.showMapAtLatLong(this);
                break;

            case R.id.menu_testPick:
                IntentsUtils.invokePick(this);
                break;

            case R.id.menu_testGetContent:
                IntentsUtils.invokeGetContent(this);
                break;
        }
    }

    private TextView getTextView() {
        TextView tv = findViewById(R.id.textViewId);
        return tv;
    }

    public void appendText(String text) {
        TextView tv = findViewById(R.id.textViewId);
        tv.setText(tv.getText() + text);
    }

    public void appendMenuItemText(MenuItem menuItem) {
        String title = menuItem.getTitle().toString();
        TextView tv = findViewById(R.id.textViewId);
        tv.setText(tv.getText() + "\n" + title + ":" + menuItem.getItemId());
    }

    private void emptyText() {
        TextView tv = findViewById(R.id.textViewId);
        tv.setText("");
    }

    private void dial() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void setupButton() {
        Button b = findViewById(R.id.button1);
        b.setOnClickListener(v -> parentButtonClicked(v));
    }

    private void parentButtonClicked(View v) {
        appendText("\nbutton clicked");
        dialUsingEditText();
    }

    private void dialWithNumber(String tel) {
        String telUriString = "tel:" + tel;
        Log.d(TAG, telUriString);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(telUriString));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void dialUsingEditText() {
        EditText etext = findViewById(R.id.editTextId);
        String text = etext.getText().toString();
        if (PhoneNumberUtils.isGlobalPhoneNumber(text) == true) {
            dialWithNumber(text);
        }
    }

    private EditText getEditText() {
        EditText etext = findViewById(R.id.editTextId);
        return etext;
    }

    private void setupEditText() {
        EditText etext = getEditText();
        etext.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentsUtils.parseResult(this, requestCode, resultCode, data);
    }
}