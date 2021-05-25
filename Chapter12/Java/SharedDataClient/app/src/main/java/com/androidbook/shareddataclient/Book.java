package com.androidbook.shareddataclient;

public class Book {

    private String mName;
    private String mIsbn;
    private String mAuthor;
    private long mCreated;

    public Book(String name, String isbn, String author, long created) {
        this.mName = name;
        this.mIsbn = isbn;
        this.mAuthor = author;
        this.mCreated = created;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getIsbn() {
        return mIsbn;
    }

    public void setIsbn(String isbn) {
        this.mIsbn = isbn;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        this.mAuthor = author;
    }

    public long getCreated() {
        return mCreated;
    }

    public void setCreated(long created) {
        this.mCreated = created;
    }

    @Override
    public String toString() {
        return "Book{" +
                "mName='" + mName + '\'' +
                ", mIsbn='" + mIsbn + '\'' +
                ", mAuthor='" + mAuthor + '\'' +
                ", mCreated=" + mCreated +
                '}';
    }
}
