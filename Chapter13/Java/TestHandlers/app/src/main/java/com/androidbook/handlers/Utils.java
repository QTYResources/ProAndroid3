package com.androidbook.handlers;

import android.os.Bundle;
import android.util.Log;

public class Utils {

    public static long getThreadId() {
        Thread t = Thread.currentThread();
        return t.getId();
    }

    public static String getThradSignature() {
        Thread t = Thread.currentThread();
        long l = t.getId();
        String name = t.getName();
        long p = t.getPriority();
        String gname = "null";
        if (t.getThreadGroup() != null) {
            gname = t.getName();
        }
        return (name + ":(id)" + l + ":(priority)" + p +
                ":(group)" + gname);
    }

    public static void logThreadSignature() {
        Log.d("ThreadUtils", getThradSignature());
    }

    public static void sleepForInSecs(int secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("interrupted", e);
        }
    }

    public static Bundle getStringAsABundle(String message) {
        Bundle b = new Bundle();
        b.putString("message", message);
        return b;
    }

    public static String getStringFromABundle(Bundle b) {
        return b.getString("message");
    }

}