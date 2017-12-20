package com.xiaozhu.refresh.impl;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.xiaozhu.refresh.SmartRefreshLayout;
import com.xiaozhu.refresh.api.RefreshHeader;
import com.xiaozhu.refresh.api.RefreshKernel;
import com.xiaozhu.refresh.api.RefreshLayout;
import com.xiaozhu.refresh.constant.RefreshState;
import com.xiaozhu.refresh.constant.SpinnerStyle;

/**
 * @说明 刷新头部包装
 * @作者 LY
 * @时间 2017/12/20 9:57
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public class RefreshHeaderWrapper implements RefreshHeader {

    private static final String TAG_REFRESH_HEADER_WRAPPER = "TAG_REFRESH_HEADER_WRAPPER";

    private View mWrapperView;
    private SpinnerStyle mSpinnerStyle;

    public RefreshHeaderWrapper(View wrapper) {
        this.mWrapperView = wrapper;
        this.mWrapperView.setTag(TAG_REFRESH_HEADER_WRAPPER.hashCode(), TAG_REFRESH_HEADER_WRAPPER);
    }

    public static boolean isTagedHeader(View view) {
        return TAG_REFRESH_HEADER_WRAPPER.equals(view.getTag(TAG_REFRESH_HEADER_WRAPPER.hashCode()));
    }

    @NonNull
    public View getView() {
        return mWrapperView;
    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
        return 0;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        if (mSpinnerStyle != null) {
            return mSpinnerStyle;
        }
        ViewGroup.LayoutParams params = mWrapperView.getLayoutParams();
        if (params instanceof SmartRefreshLayout.LayoutParams) {
            mSpinnerStyle = ((SmartRefreshLayout.LayoutParams) params).spinnerStyle;
            if (mSpinnerStyle != null) {
                return mSpinnerStyle;
            }
        }
        if (params != null) {
            if (params.height == ViewGroup.LayoutParams.MATCH_PARENT) {
                return mSpinnerStyle = SpinnerStyle.Scale;
            }
        }
        return mSpinnerStyle = SpinnerStyle.Translate;
    }

    @Override
    public void onInitialized(RefreshKernel kernel, int height, int extendHeight) {
        ViewGroup.LayoutParams params = mWrapperView.getLayoutParams();
        if (params instanceof SmartRefreshLayout.LayoutParams) {
            kernel.requestDrawBackgoundForHeader(((SmartRefreshLayout.LayoutParams) params).backgroundColor);
        }
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
    }

    @Override
    public void onPullingDown(float percent, int offset, int headHeight, int extendHeight) {

    }

    @Override
    public void onReleasing(float percent, int offset, int headHeight, int extendHeight) {

    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int headHeight, int extendHeight) {

    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {

    }
}
