package com.androidbook.commoncontrols;

import android.database.Cursor;
import android.os.Bundle;
<<<<<<< HEAD
import android.provider.Contacts.People;
=======
>>>>>>> afbbc0f (添加第6章源代码)
import android.provider.ContactsContract;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;

import androidx.activity.ComponentActivity;

public class GridViewActivity extends ComponentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        GridView gv = findViewById(R.id.gridview);

        Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, ContactsContract.Contacts.DISPLAY_NAME);

        String[] cols = new String[]{ContactsContract.Contacts.DISPLAY_NAME};
        int[] views = new int[]{android.R.id.text1};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                c, cols, views);
        gv.setAdapter(adapter);
    }
}
