package com.xiaozhu.refresh.listener;

import com.xiaozhu.refresh.api.RefreshLayout;
import com.xiaozhu.refresh.constant.RefreshState;

/**
 * @说明 刷新状态改变监听器
 * @作者 LY
 * @时间 2017/12/20 9:57
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public interface OnStateChangedListener {
    /**
     * 状态改变事件 {@link RefreshState}
     *
     * @param refreshLayout RefreshLayout
     * @param oldState      改变之前的状态
     * @param newState      改变之后的状态
     */
    void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState);
}
