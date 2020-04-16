package com.lightning.demo.task.normal_task;


import android.util.Log;

import com.lightning.lib.task.Task;


/**
 * Author: Jett
 * Date: 2019-03-19 15:57
 * Email: hydznsq@163.com
 * Des:模拟友盟统计的初始化,在子线程中
 */
public class InitUmengTask extends Task {

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(100);
        }catch (Exception e){
        }
        Log.i("DemoTask","InitUmengTask执行耗时: "+(System.currentTimeMillis()-start) + "毫秒");
    }
}
