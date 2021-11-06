package com.ai.android.book.provider

/*
 * An interface implemented typically by an activity
 * so that a worker class can report back
 * on what happened.
 */
interface IReportBack {
    fun reportBack(tag: String, message: String)
}