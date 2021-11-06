package com.ai.android.book.resources

/*
 * An interface implemented typically by an activity
 * so that a worker class can report back
 * on what happeened.
 */
interface IReportBack {
    fun reportBack(tag: String, message: String);
}