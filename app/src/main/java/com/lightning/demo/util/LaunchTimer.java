package com.lightning.demo.util;


import android.util.Log;


/**
 * Author: 信仰年轻
 * Date: 2019-03-19 12:39
 * Email: hydznsq@163.com
 * Des:
 */
public class LaunchTimer {

    private static long sTime;

    public static void startRecord() {
        sTime = System.currentTimeMillis();
    }

    public static void endRecord() {
        endRecord("");
    }

    public static void endRecord(String msg) {
        long cost = System.currentTimeMillis() - sTime;
        Log.d("DemoTask", msg + "  耗时: " + cost+"毫秒");
    }

}
