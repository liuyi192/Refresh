package com.xiaozhu.refresh.api;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

/**
 * @说明 刷新内容组件
 * @作者 LY
 * @时间 2017/12/20 9:57
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public interface RefreshContent {
    void moveSpinner(int spinner);

    boolean canScrollUp();

    boolean canScrollDown();

    int getMeasuredWidth();

    int getMeasuredHeight();

    void measure(int widthSpec, int heightSpec);

    void layout(int left, int top, int right, int bottom);

    View getView();

    View getScrollableView();

    ViewGroup.LayoutParams getLayoutParams();

    void onActionDown(MotionEvent e);

    void onActionUpOrCancel();

    void setupComponent(RefreshKernel kernel, View fixedHeader, View fixedFooter);

    void onInitialHeaderAndFooter(int headerHeight, int footerHeight);

    void setRefreshScrollBoundary(RefreshScrollBoundary boundary);

    boolean isNestedScrollingChild(MotionEvent e);

    AnimatorUpdateListener onLoadingFinish(RefreshKernel kernel, int footerHeight, int startDelay, Interpolator reboundInterpolator, int reboundDuration);

}
