package com.lightning.lib;

import android.os.Looper;
import android.os.MessageQueue;

import com.lightning.lib.task.DispatchRunnable;
import com.lightning.lib.task.Task;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Author: Jett
 * Date: 2019-03-19 17:49
 * Email: hydznsqk@163.com
 * Des:
 */
public class DelayInitDispatcher {

    private Queue<Task> mDelayTasks = new LinkedList<>();

    private MessageQueue.IdleHandler mIdleHandler = new MessageQueue.IdleHandler() {
        @Override
        public boolean queueIdle() {
            if (mDelayTasks.size() > 0) {
                Task task = mDelayTasks.poll();
                new DispatchRunnable(task).run();
            }
            return !mDelayTasks.isEmpty();
        }
    };

    public DelayInitDispatcher addTask(Task task) {
        mDelayTasks.add(task);
        return this;
    }

    public void start() {
        Looper.myQueue().addIdleHandler(mIdleHandler);
    }

}
