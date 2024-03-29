package com.ai.android.book.resources;

/*
 * An interface implemented typically by an activity
 * so that a worker class can report back
 * on what happened.
 */
public interface IReportBack {

    void reportBack(String tag, String message);

}
