package com.androidbook.handlers;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class ReportStatusHandler extends Handler {

    private static final String TAG = "TestHandler2";

    private final TestHandlersDriverActivity parentActivity;

    public ReportStatusHandler(TestHandlersDriverActivity inParentActivity) {
        parentActivity = inParentActivity;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        String pm = Utils.getStringFromABundle(msg.getData());

        Log.d(TAG, pm);
        printMessage(pm);
    }

    private void printMessage(String xyz) {
        parentActivity.appendText(xyz);
    }

}