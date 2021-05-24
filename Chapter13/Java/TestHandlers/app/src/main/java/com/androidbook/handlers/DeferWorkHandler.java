package com.androidbook.handlers;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class DeferWorkHandler extends Handler {

    public static final String TAG = "TestHandler1";

    private int count = 0;
    private final TestHandlersDriverActivity parentActivity;

    public DeferWorkHandler(TestHandlersDriverActivity inParentActivity) {
        parentActivity = inParentActivity;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        String pm = "message called:" + count + ":" +
                msg.getData().getString("message");

        Log.d(TAG, pm);
        printMessage(pm);

        if (count > 5) return;
        count++;
        sendTestMessage(1);
    }

    public void sendTestMessage(long interval) {
        Message m = obtainMessage();
        prepareMessage(m);
        sendMessageDelayed(m, interval * 1000);
    }

    public void doDeferredWork() {
        count = 0;
        sendTestMessage(1);
    }

    public void prepareMessage(Message m) {
        Bundle b = new Bundle();
        b.putString("message", "Hello World");
        m.setData(b);
    }

    private void printMessage(String xyz) {
        parentActivity.appendText(xyz);
    }
}