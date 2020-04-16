package com.lightning.lib.utils;

import android.util.Log;

/**
 * Author: Jett
 * Date: 2019-03-19 17:14
 * Email: hydznsqk@163.com
 * Des:
 */
public class DispatcherLog {

    private static boolean sDebug = true;

    public static void i(String msg) {
        if (!sDebug) {
            return;
        }
        Log.i("task", msg);
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static void setDebug(boolean debug) {
        sDebug = debug;
    }

}
