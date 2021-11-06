package com.ai.android.book.provider

import android.content.Context

open class BaseTester(
    protected var mContext: Context,
    protected var mReportTo: IReportBack,
)
