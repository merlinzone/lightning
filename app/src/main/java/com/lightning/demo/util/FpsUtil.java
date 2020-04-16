package com.lightning.demo.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.Choreographer;

/**
 * Author: Jett
 * Date: 2019-03-22 10:57
 * Email: hydznsq@163.com
 * Des:FPS工具类
 */
public class FpsUtil {

    private static long mStartFrameTime = 0;
    private static int mFrameCount = 0;
    private static final long MONITOR_INTERVAL = 160L; //单次计算FPS使用160毫秒
    private static final long MONITOR_INTERVAL_NANOS = MONITOR_INTERVAL * 1000L * 1000L;
    private static final long MAX_INTERVAL = 1000L; //设置计算fps的单位时间间隔1000ms,即fps/s;


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void getFPS() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            return;
        }

        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long frameTimeNanos) {
                if (mStartFrameTime == 0) {
                    mStartFrameTime = frameTimeNanos;
                }
                long interval = frameTimeNanos - mStartFrameTime;
                if (interval > MONITOR_INTERVAL_NANOS) {
                    double fps = (((double) (mFrameCount * 1000L * 1000L)) / interval) * MAX_INTERVAL;
//                    Log.e("DemoFPS", "fps = "+fps);

                    mFrameCount = 0;
                    mStartFrameTime = 0;
                } else {
                    ++mFrameCount;
                }

                Choreographer.getInstance().postFrameCallback(this);
            }
        });
    }
}
