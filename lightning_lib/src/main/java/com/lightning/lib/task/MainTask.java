package com.lightning.lib.task;

/**
 * Author: Jett
 * Date: 2019-03-19 16:13
 * Email: hydznsqk@163.com
 * Des:
 */
public abstract class MainTask extends Task {

    @Override
    public boolean runOnMainThread() {
        return true;
    }
}
