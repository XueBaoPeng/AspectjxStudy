package com.example.aspectjaop;

import android.util.Log;

/**
 * @des:
 * @author: 薛宝鹏
 * @date: 2018/4/21 17:37
 */
public class DebugLog {
    private DebugLog() {}

    /**
     * Send a debug log message
     *
     * @param tag Source of a log message. It usually identifies the class or activity where the log
     * call occurs.
     * @param message The message you would like logged.
     */
    public static void log(String tag, String message) {
        Log.d(tag, message);
    }
}
