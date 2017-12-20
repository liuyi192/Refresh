package com.xiaozhu.refresh.impl;

import android.view.MotionEvent;
import android.view.View;

import com.xiaozhu.refresh.api.RefreshScrollBoundary;

import static com.xiaozhu.refresh.util.ScrollBoundaryUtil.canScrollDown;
import static com.xiaozhu.refresh.util.ScrollBoundaryUtil.canScrollUp;

/**
 * @说明 滚动边界
 * @作者 LY
 * @时间 2017/12/20 9:57
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public class RefreshScrollBoundaryAdapter implements RefreshScrollBoundary {
    MotionEvent mActionEvent;
    RefreshScrollBoundary boundary;

    void setRefreshScrollBoundary(RefreshScrollBoundary boundary) {
        this.boundary = boundary;
    }

    void setActionEvent(MotionEvent event) {
        mActionEvent = event;
    }

    @Override
    public boolean canPullDown(View content) {
        if (boundary != null) {
            return boundary.canPullDown(content);
        }
        return canScrollUp(content, mActionEvent);
    }

    @Override
    public boolean canPullUp(View content) {
        if (boundary != null) {
            return boundary.canPullUp(content);
        }
        return canScrollDown(content, mActionEvent);
    }
}
