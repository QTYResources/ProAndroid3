package com.androidbook.shareddataclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SharedDataClientActivity extends AppCompatActivity {

    private static final String TAG = "SharedDataClient";

    public static final String DATABASE_NAME = "MyDb";

    public static final String TABLE_NAME = "book";
    public static final String _ID = "id";
    public static final String BOOK_NAME = "name";
    public static final String BOOK_ISBN = "isbn";
    public static final String BOOK_AUTHOR = "author";
    public static final String CREATED_DATE = "created";

    private TextView mTextView;
    private Context mOtherContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.text1);
        try {
            mOtherContext = createPackageContext("com.androidbook.shared", Context.CONTEXT_RESTRICTED);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "onCreate=>error: ", e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        appendMenuItemText(item);
        switch (item.getItemId()) {
            case R.id.clear:
                emptyText();
                break;

            case R.id.read_string:
                readStringResource();
                break;

            case R.id.read_raw:
                readRawResource();
                break;

            case R.id.read_assert:
                readAssetsResource();
                break;

            case R.id.read_preference:
                readSharedPreferences();
                break;

            case R.id.read_database:
                readDatabase();
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

    private void readStringResource() {
        int resourceId = mOtherContext.getResources().getIdentifier("hello_world",
                "string", mOtherContext.getPackageName());
        String resourceValue = mOtherContext.getResources().getString(resourceId);
        mTextView.setText(String.format("%s\n%s", mTextView.getText(), resourceValue));
    }

    private void readRawResource() {
        int resourceId = mOtherContext.getResources().getIdentifier("raw",
                "raw", mOtherContext.getPackageName());
        InputStream in = mOtherContext.getResources().openRawResource(resourceId);
        BufferedReader br = null;
        String value = "null";
        try {
            br = new BufferedReader(new InputStreamReader(in));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) != null) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(line);
            }
            value = sb.toString();
        } catch (Exception e) {
            Log.e(TAG, "readRawResource=>error:", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception ignore) {}
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ignore) {}
            }
        }
        mTextView.setText(String.format("%s\n%s", mTextView.getText(), value));
    }

    private void readAssetsResource() {
        InputStream in = null;
        BufferedReader br = null;
        String value = "null";
        try {
            in = mOtherContext.getAssets().open("assets.txt");
            br = new BufferedReader(new InputStreamReader(in));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) != null) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(line);
            }
            value = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception ignore) {}
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ignore) {}
            }
        }
        mTextView.setText(String.format("%s\n%s", mTextView.getText(), value));
    }

    private void readSharedPreferences() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(mOtherContext);
        Map<String, ?> all = sp.getAll();
        Log.d(TAG, "readSharedPreferences=>size: " + (all != null ? all.size() : "null"));
        String value = sp.getString("hello_world", "null");
        mTextView.setText(String.format("%s\n%s", mTextView.getText(), value));
    }

    private void readDatabase() {
        Book book = null;
        try {
            SQLiteDatabase db = mOtherContext.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
            Cursor c = db.query(TABLE_NAME, new String[]{_ID, BOOK_NAME, BOOK_ISBN, BOOK_AUTHOR, CREATED_DATE}, BOOK_ISBN + "= ?",
                    new String[]{"978-7-115-26602-6"}, null, null, null);
            if (c.getCount() > 0) {
                c.moveToFirst();
                String name = c.getString(c.getColumnIndex(BOOK_NAME));
                String ib = c.getString(c.getColumnIndex(BOOK_ISBN));
                String author = c.getString(c.getColumnIndex(BOOK_AUTHOR));
                long created = c.getLong(c.getColumnIndex(CREATED_DATE));
                book = new Book(name, ib, author, created);
            }
        } catch (Exception e) {
            Log.e(TAG, "readDatabaase=>error: ", e);
        }
        mTextView.setText(String.format("%s\n%s", mTextView.getText(), (book != null ? book.toString() : "null")));
    }
}