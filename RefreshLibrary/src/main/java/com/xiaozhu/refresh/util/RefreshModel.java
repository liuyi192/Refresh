package com.xiaozhu.refresh.util;

/**
 * @说明 刷新；类型
 * @作者 LY
 * @时间 2017/9/4 下午7:47
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public enum RefreshModel {
    DISABLED(0),//默认无刷新
    PULL_FROM_START(1),//刷新头部
    PULL_FROM_END(2),//刷新底部
    BOTH(3);//头部底部刷新
    private int type;

    RefreshModel(int type) {
        this.type = type;
    }

    public static RefreshModel getModel(int type) {
        for (RefreshModel c : RefreshModel.values()) {
            if (c.getType() == type) {
                return c;
            }
        }
        return DISABLED;
    }

    public int getType() {
        return type;
    }
}
