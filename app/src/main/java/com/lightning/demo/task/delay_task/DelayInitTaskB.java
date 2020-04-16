package com.lightning.demo.task.delay_task;

import android.util.Log;

import com.lightning.lib.task.MainTask;


/**
 * Author: Jett
 * Date: 2019-03-19 18:24
 * Email: hydznsq@163.com
 * Des:
 */
public class DelayInitTaskB extends MainTask {

    @Override
    public void run() {
        Log.i("DemoTask","DelayInitTaskB 开始了 ");
        // 模拟一些操作
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("DemoTask","DelayInitTaskB 完成了 ");
    }
}