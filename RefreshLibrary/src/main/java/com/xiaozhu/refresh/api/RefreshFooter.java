package com.xiaozhu.refresh.api;

/**
 * @说明 刷新底部
 * @作者 LY
 * @时间 2017/12/20 9:57
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public interface RefreshFooter extends RefreshInternal {
    /**
     * 手指拖动下拉（会连续多次调用）
     *
     * @param percent      下拉的百分比 值 = offset/footerHeight (0 - percent - (footerHeight+extendHeight) / footerHeight )
     * @param offset       下拉的像素偏移量  0 - offset - (footerHeight+extendHeight)
     * @param footerHeight Footer的高度
     * @param extendHeight Footer的扩展高度
     */
    void onPullingUp(float percent, int offset, int footerHeight, int extendHeight);

    /**
     * 手指释放之后的持续动画（会连续多次调用）
     *
     * @param percent      下拉的百分比 值 = offset/footerHeight (0 - percent - (footerHeight+extendHeight) / footerHeight )
     * @param offset       下拉的像素偏移量  0 - offset - (footerHeight+extendHeight)
     * @param footerHeight Footer的高度
     * @param extendHeight Footer的扩展高度
     */
    void onPullReleasing(float percent, int offset, int footerHeight, int extendHeight);

    /**
     * 设置数据全部加载完成，将不能再次触发加载功能
     *
     * @return true 支持全部加载完成的状态显示 false 不支持
     */
    boolean setLoadmoreFinished(boolean finished);
}
