package com.xiaozhu.refresh.api;

import android.view.View;

/**
 * @说明 滚动边界
 * @作者 LY
 * @时间 2017/12/20 9:57
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public interface RefreshScrollBoundary {
    /**
     * 内容是否可以下拉滚动
     *
     * @param content 内容视图
     * @return false 将会触发下拉刷新
     */
    boolean canPullDown(View content);

    /**
     * 内容是否可以上拉滚动
     *
     * @param content 内容视图
     * @return false 将会触发加载更多
     */
    boolean canPullUp(View content);
}
