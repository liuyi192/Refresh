package com.xiaozhu.refresh.constant;

/**
 * @说明 刷新类型
 * @作者 LY
 * @时间 2017/12/20 9:57
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public enum RefreshState {
    None,
    PullDownToRefresh,
    PullToUpLoad,
    PullDownCanceled,
    PullUpCanceled,
    ReleaseToRefresh,
    ReleaseToLoad,
    Refreshing,
    Loading,
    RefreshFinish,
    LoadFinish;

    public boolean isAnimating() {
        return this == Refreshing || this == Loading;
    }

    public boolean isDraging() {
        return ordinal() >= PullDownToRefresh.ordinal() && ordinal() <= ReleaseToLoad.ordinal() && this != PullDownCanceled && this != PullUpCanceled;
    }

    public boolean isDragingHeader() {
        return this == PullDownToRefresh || this == ReleaseToRefresh;
    }

    public boolean isDragingFooter() {
        return this == PullToUpLoad || this == ReleaseToLoad;
    }

    public boolean isHeader() {
        return (ordinal() & 1) == 1;
    }

    public boolean isFooter() {
        return (ordinal() & 1) == 0 && ordinal() > 0;
    }

}