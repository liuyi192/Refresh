package com.xiaozhu.refresh.dome;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xiaozhu.refresh.SmartRefreshLayout;
import com.xiaozhu.refresh.api.RefreshLayout;
import com.xiaozhu.refresh.constant.RefreshState;
import com.xiaozhu.refresh.dome.adapter.MainAdapter;
import com.xiaozhu.refresh.listener.OnRefreshLoadmoreListener;
import com.xiaozhu.refresh.listener.SimpleMultiPurposeListener;
import com.xiaozhu.refresh.util.RefreshModel;
import com.xiaozhu.refresh.util.RefreshUtils;

public class MainActivity extends AppCompatActivity {
    private SmartRefreshLayout refreshView;
    private RecyclerView recycleList;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshView = this.findViewById(R.id.refreshView);
        recycleList = this.findViewById(R.id.recycleList);

        RefreshUtils.getInstance().init(this, refreshView, RefreshModel.PULL_FROM_START);
        recycleList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(this);

        //设置刷新监听
        refreshView.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                loadData();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                //刷新
                startRefresh();
                loadData();
            }
        });
        refreshView.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
            @Override
            public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
                if (oldState == RefreshState.LoadFinish && newState == RefreshState.None) { //加载完成
                    stopRefresh();
                } else if (oldState == RefreshState.RefreshFinish && newState == RefreshState.None) {//刷新完成
                    stopRefresh();
                }
            }
        });
        startRefresh();
    }

    private void loadData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                recycleList.setAdapter(adapter);
                stopRefresh();
            }
        }, 3000);
    }

    public void stopRefresh() {
        refreshView.finishRefresh();
        refreshView.finishLoadmore();
    }

    public void startRefresh() {
        refreshView.autoRefresh();
    }
}
