package com.androidbook.commoncontrols;

<<<<<<< HEAD
import android.app.ListActivity;
=======
>>>>>>> afbbc0f (添加第6章源代码)
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
<<<<<<< HEAD
import android.provider.Contacts.People;
=======
>>>>>>> afbbc0f (添加第6章源代码)
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

<<<<<<< HEAD
public class ListViewActivity2 extends ListActivity implements OnItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView lv = getListView();
=======
import androidx.appcompat.app.AppCompatActivity;

public class ListViewActivity2 extends AppCompatActivity implements OnItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        ListView lv = findViewById(android.R.id.list);
>>>>>>> afbbc0f (添加第6章源代码)

        Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, ContactsContract.Contacts.DISPLAY_NAME);

        String[] cols = new String[]{ContactsContract.Contacts.DISPLAY_NAME};
        int[] views = new int[]{android.R.id.text1};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                c, cols, views);
<<<<<<< HEAD
        this.setListAdapter(adapter);
=======
        lv.setAdapter(adapter);
>>>>>>> afbbc0f (添加第6章源代码)
        lv.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adView, View target, int position, long id) {
        Log.v("ListViewActivity", "in onItemClick with " + ((TextView) target).getText() +
                ". Position = " + position + ". Id = " + id);
        Uri selectedPerson = ContentUris.withAppendedId(
                ContactsContract.Contacts.CONTENT_URI, id);
        Intent intent = new Intent(Intent.ACTION_VIEW, selectedPerson);
        startActivity(intent);
    }
}
