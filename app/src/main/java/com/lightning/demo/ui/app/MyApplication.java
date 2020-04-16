package com.lightning.demo.ui.app;

import android.app.Application;
import android.content.Context;

import com.lightning.demo.task.normal_task.InitBuglyTask;
import com.lightning.demo.task.normal_task.InitLogTask;
import com.lightning.demo.task.normal_task.InitUmengTask;
import com.lightning.demo.util.LaunchTimer;
import com.lightning.lib.TaskDispatcher;

/**
 * Author: Jett
 * Date: 2020-04-15 15:02
 * Email: hydznsq@163.com
 * Des:
 */
public class MyApplication extends Application {

    private static Application mApplication;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        LaunchTimer.startRecord();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication=this;
        initTasks();
    }

    private void initTasks() {
        TaskDispatcher.init(this);
        TaskDispatcher dispatcher = TaskDispatcher.createInstance();
        dispatcher
                .addTask(new InitBuglyTask())
                .addTask(new InitLogTask())
                .addTask(new InitUmengTask())
                .start();
        dispatcher.await();
    }

    public static Application getApplication() {
        return mApplication;
    }

}
