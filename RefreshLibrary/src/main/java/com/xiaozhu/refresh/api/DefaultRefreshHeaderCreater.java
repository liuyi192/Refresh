package com.xiaozhu.refresh.api;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * @说明 默认Header创建器
 * @作者 LY
 * @时间 2017/12/20 9:57
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public interface DefaultRefreshHeaderCreater {
    @NonNull
    RefreshHeader createRefreshHeader(Context context, RefreshLayout layout);
}
