package com.androidbook.handlers;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class WorkerThreadRunnable implements Runnable {

    private static final String TAG = "TestRunnable";

    private final Handler mainThreadHandler;

    public WorkerThreadRunnable(Handler h) {
        mainThreadHandler = h;
    }

    @Override
    public void run() {
        Log.d(TAG, "start execution");
        informStart();
        for (int i = 1; i <= 10; i++) {
            Utils.sleepForInSecs(1);
            informMiddle(i);
        }
        informFinish();
    }

    private void informMiddle(int count) {
        Message m = mainThreadHandler.obtainMessage();
        m.setData(Utils.getStringAsABundle("done:" + count));
        mainThreadHandler.sendMessage(m);
    }

    private void informStart() {
        Message m = mainThreadHandler.obtainMessage();
        m.setData(Utils.getStringAsABundle("starting run"));
        mainThreadHandler.sendMessage(m);
    }

    private void informFinish() {
        Message m = mainThreadHandler.obtainMessage();
        m.setData(Utils.getStringAsABundle("Finishing run"));
        mainThreadHandler.sendMessage(m);
    }

}