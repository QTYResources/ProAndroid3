package com.androidbook.shared;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class SharedDataServiceActivity extends AppCompatActivity {

    private static final String TAG = "SharedDataServiceActivity";

    private TextView mTextView;
    private BookProvider mProvider;
    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.text1);
        mProvider = BookProvider.getInstance(this);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        appendMenuItemText(item);
        switch (item.getItemId()) {
            case R.id.clear:
                emptyText();
                break;

            case R.id.set_preference:
                setPreference();
                break;

            case R.id.insert_database:
                inserDatabase();
                break;
        }
        return true;
    }

    private void appendMenuItemText(MenuItem item) {
        String title = item.getTitle().toString();
        mTextView.setText(String.format("%s\n%s", mTextView.getText(), title));
    }

    private void emptyText() {
        mTextView.setText("");
    }

    private void setPreference() {
        mPreferences.edit().putString("hello_world", "This is SharedDataService app SharedPreferences hello world string.").apply();
        mTextView.setText(String.format("%s\n%s", mTextView.getText(), mPreferences.getString("hello_world", "")));
    }

    private void inserDatabase() {
        Book book = new Book("Pro Android 3", "978-7-115-26602-6", "Komatineni, S.", System.currentTimeMillis());
        mProvider.insert(book);
        Book b = mProvider.getBook("978-7-115-26602-6");
        mTextView.setText(String.format("%s\n%s", mTextView.getText(), b != null ? b.toString() : "null"));
    }

}