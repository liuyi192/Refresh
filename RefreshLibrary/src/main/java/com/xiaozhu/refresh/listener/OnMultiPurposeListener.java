package com.xiaozhu.refresh.listener;

import com.xiaozhu.refresh.api.RefreshFooter;
import com.xiaozhu.refresh.api.RefreshHeader;

/**
 * @说明 多功能监听器
 * @作者 LY
 * @时间 2017/12/20 9:57
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public interface OnMultiPurposeListener extends OnRefreshLoadmoreListener, OnStateChangedListener {
    void onHeaderPulling(RefreshHeader header, float percent, int offset, int headerHeight, int extendHeight);

    void onHeaderReleasing(RefreshHeader header, float percent, int offset, int headerHeight, int extendHeight);

    void onHeaderStartAnimator(RefreshHeader header, int headerHeight, int extendHeight);

    void onHeaderFinish(RefreshHeader header, boolean success);

    void onFooterPulling(RefreshFooter footer, float percent, int offset, int footerHeight, int extendHeight);

    void onFooterReleasing(RefreshFooter footer, float percent, int offset, int footerHeight, int extendHeight);

    void onFooterStartAnimator(RefreshFooter footer, int footerHeight, int extendHeight);

    void onFooterFinish(RefreshFooter footer, boolean success);
}
