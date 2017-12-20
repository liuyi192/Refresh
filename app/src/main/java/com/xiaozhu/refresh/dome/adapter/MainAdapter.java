package com.xiaozhu.refresh.dome.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaozhu.refresh.dome.R;

/**
 * @说明
 * @作者 LY
 * @时间 2017/12/20 11:28
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {
    private Context context;

    public MainAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.common_list_item, parent, false);
        return new MainViewHolder(contentView);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 60;
    }
}
