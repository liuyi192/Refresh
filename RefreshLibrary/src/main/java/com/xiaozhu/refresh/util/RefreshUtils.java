package com.xiaozhu.refresh.util;

import android.content.Context;

import com.xiaozhu.refresh.R;
import com.xiaozhu.refresh.SmartRefreshLayout;
import com.xiaozhu.refresh.constant.SpinnerStyle;
import com.xiaozhu.refresh.footer.BallPulseFooter;
import com.xiaozhu.refresh.refresh.MaterialHeader;

/**
 * @说明 刷新工具类
 * @作者 LY
 * @时间 2017/10/16 13:14
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public class RefreshUtils {
    private SmartRefreshLayout refreshLayout;
    private static RefreshUtils mInstance;

    public static RefreshUtils getInstance() {
        if (mInstance == null) {
            synchronized (RefreshUtils.class) {
                if (mInstance == null) {
                    mInstance = new RefreshUtils();
                }
            }
        }
        return mInstance;
    }


    public void init(Context context, SmartRefreshLayout refreshLayout, RefreshModel refreshModel) {
        this.refreshLayout = refreshLayout;
        //设置刷新控件主题
        refreshLayout.setPrimaryColorsId(R.color.refresh_layout_bg, R.color.refresh_layout_primary);
        refreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(true));
        //底部控件主题
        BallPulseFooter ballPulseFooter = new BallPulseFooter(context);
        ballPulseFooter.setSpinnerStyle(SpinnerStyle.Scale);
        ballPulseFooter.setBackgroundColor(context.getResources().getColor(R.color.refresh_layout_bg));
        refreshLayout.setRefreshFooter(ballPulseFooter);
        //设置刷新类型
        setRefresh(refreshModel);
    }

    /**
     * 设置刷新
     */
    private void setRefresh(RefreshModel refreshModel) {
        //设置刷新类型
        if (refreshModel == RefreshModel.PULL_FROM_START) {//头部刷新
            refreshLayout.setEnableRefresh(true);
            refreshLayout.setEnableLoadmore(false);
        } else if (refreshModel == RefreshModel.PULL_FROM_END) {//底部加载
            refreshLayout.setEnableRefresh(false);
            refreshLayout.setEnableLoadmore(true);
        } else if (refreshModel == RefreshModel.BOTH) {//刷新和加载
            refreshLayout.setEnableRefresh(true);
            refreshLayout.setEnableLoadmore(true);
        } else {//不刷新也不加载
            refreshLayout.setEnableRefresh(false);
            refreshLayout.setEnableLoadmore(false);
        }
    }
}
