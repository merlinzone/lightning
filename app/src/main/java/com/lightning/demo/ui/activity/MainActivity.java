package com.lightning.demo.ui.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lightning.demo.R;
import com.lightning.demo.task.delay_task.DelayInitTaskA;
import com.lightning.demo.task.delay_task.DelayInitTaskB;
import com.lightning.demo.ui.adapter.GirlAdapter;
import com.lightning.demo.ui.adapter.GirlModel;
import com.lightning.demo.util.FpsUtil;
import com.lightning.demo.util.LaunchTimer;
import com.lightning.lib.DelayInitDispatcher;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        GirlAdapter.OnFeedShowCallBack {

    private RecyclerView mRecyclerView;
    private List<GirlModel> mDataList;
    private GirlAdapter mGirlAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FpsUtil.getFPS();
        initData();
        initView();
    }

    private void initData() {
        mDataList = new ArrayList<>();
        mDataList.add(new GirlModel(R.drawable.f1, "一星", "****"));
        mDataList.add(new GirlModel(R.drawable.f2, "一星", "****"));
        mDataList.add(new GirlModel(R.drawable.f3, "一星", "****"));
        mDataList.add(new GirlModel(R.drawable.f4, "一星", "****"));
        mDataList.add(new GirlModel(R.drawable.f5, "一星", "****"));
        mDataList.add(new GirlModel(R.drawable.f6, "一星", "****"));
        mDataList.add(new GirlModel(R.drawable.f7, "一星", "****"));
        mDataList.add(new GirlModel(R.drawable.f8, "一星", "****"));
        mDataList.add(new GirlModel(R.drawable.f9, "一星", "****"));
        mDataList.add(new GirlModel(R.drawable.f10, "一星", "****"));
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mGirlAdapter = new GirlAdapter(mDataList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.setAdapter(mGirlAdapter);
        mGirlAdapter.setOnFeedShowCallBack(this);
    }

    /**
     * 异步延迟懒加载 是总方针
     * 比如说详情页用到高德地图,才会在那个页面加载高德地图
     */
    @Override
    public void onFeedShow() {
        //利用IdleHandler特性,空闲执行
        //对延迟任务进行分批初始化
        //每次只会执行一个task,即便是执行一个也是在系统空闲时间执行的
        DelayInitDispatcher delayInitDispatcher = new DelayInitDispatcher();
        delayInitDispatcher.addTask(new DelayInitTaskA())
                .addTask(new DelayInitTaskB())
                .start();
        // 一系列操作 10s
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "我被点击了" + position, Toast.LENGTH_SHORT).show();
    }

    /**
     * 窗口显示的时候
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        LaunchTimer.endRecord("窗口显示");
    }

}
