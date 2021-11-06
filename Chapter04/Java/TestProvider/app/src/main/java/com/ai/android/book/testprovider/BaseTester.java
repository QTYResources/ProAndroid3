package com.ai.android.book.testprovider;

import android.content.Context;

public class BaseTester {

    protected IReportBack mReportTo;
    protected Context mContext;

    public BaseTester(Context ctx, IReportBack target) {
        mContext = ctx;
        mReportTo = target;
    }
}
