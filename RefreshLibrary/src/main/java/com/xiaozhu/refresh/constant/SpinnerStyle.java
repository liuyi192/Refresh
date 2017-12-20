package com.xiaozhu.refresh.constant;

/**
 * @说明 顶部和底部的组件在拖动时候的变换方式
 * @作者 LY
 * @时间 2017/12/20 9:57
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public enum SpinnerStyle {
    Translate,//平行移动        特点: HeaderView高度不会改变，
    Scale,//拉伸形变            特点：在下拉和上弹（HeaderView高度改变）时候，会自动触发OnDraw事件
    FixedFront,//固定在前面     特点：HeaderView高度不会改变，
    FixedBehind,//固定在背后    特点：HeaderView高度不会改变，
    MatchLayout//填满布局       特点：HeaderView高度不会改变，尺寸充满 RefreshLayout
}
