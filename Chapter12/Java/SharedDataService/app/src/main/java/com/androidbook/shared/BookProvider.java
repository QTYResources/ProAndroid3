package com.androidbook.shared;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class BookProvider {

    private static final String TAG = "BookProvider";

    public static final String DATABASE_NAME = "MyDb";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "book";
    public static final String _ID = "id";
    public static final String BOOK_NAME = "name";
    public static final String BOOK_ISBN = "isbn";
    public static final String BOOK_AUTHOR = "author";
    public static final String CREATED_DATE = "created";

    private BookHelper mDatabaseHelper;
    private static BookProvider mInstance;

    public static BookProvider getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new BookProvider(context);
        }
        return mInstance;
    }

    private BookProvider(Context context) {
        mDatabaseHelper = new BookHelper(context);
    }

    public long insert(Book book) {
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        Cursor c = db.query(TABLE_NAME, new String[]{_ID, BOOK_ISBN}, BOOK_ISBN + "= ?",
                new String[]{book.getIsbn()}, null, null, null);
        ContentValues cv = new ContentValues();
        cv.put(BOOK_NAME, book.getName());
        cv.put(BOOK_ISBN, book.getIsbn());
        cv.put(BOOK_AUTHOR, book.getAuthor());
        cv.put(CREATED_DATE, book.getCreated());
        if (c.getCount() == 0) {
            long id = db.insert(TABLE_NAME, BOOK_NAME, cv);
            return id;
        } else {
            c.moveToFirst();
            long id = c.getLong(c.getColumnIndex(_ID));
            db.update(TABLE_NAME, cv, _ID + "= ?", new String[]{ id + "" });
            return id;
        }
    }

    public Book getBook(String isbn) {
        SQLiteDatabase db = mDatabaseHelper.getReadableDatabase();
    Cursor c = db.query(TABLE_NAME, new String[]{_ID, BOOK_NAME, BOOK_ISBN, BOOK_AUTHOR, CREATED_DATE}, BOOK_ISBN + "= ?",
                new String[]{isbn}, null, null, null);
        if (c.getCount() > 0) {
            c.moveToFirst();
            String name = c.getString(c.getColumnIndex(BOOK_NAME));
            String ib = c.getString(c.getColumnIndex(BOOK_ISBN));
            String author = c.getString(c.getColumnIndex(BOOK_AUTHOR));
            long created = c.getLong(c.getColumnIndex(CREATED_DATE));
            return new Book(name, ib, author, created);
        }
        return null;
    }

    class BookHelper extends SQLiteOpenHelper {

        private static final String TAG = "BookHelper";

        public BookHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(TAG, "onCreate()...");
            db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
                    + _ID + " INTEGER PRIMARY KEY,"
                    + BOOK_NAME + " TEXT,"
                    + BOOK_ISBN + " TEXT,"
                    + BOOK_AUTHOR + " TEXT,"
                    + CREATED_DATE + " INTEGER"
                    + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d(TAG, "onUpgrade=>oldVersion: " + oldVersion + ", newVersion: " + newVersion);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}
