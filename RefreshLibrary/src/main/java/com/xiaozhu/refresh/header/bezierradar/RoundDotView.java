package com.xiaozhu.refresh.header.bezierradar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.xiaozhu.refresh.util.DensityUtil;

/**
 * @说明 轮点视图
 * @作者 LY
 * @时间 2017/12/20 9:57
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public class RoundDotView extends View {
    private int num = 7;
    private Paint mPath;
    private float mRadius;
    private float fraction;

    public RoundDotView(Context context) {
        super(context);
        mPath = new Paint();
        mPath.setAntiAlias(true);
        mPath.setColor(Color.WHITE);
        mRadius = DensityUtil.dp2px(7);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(resolveSize(getSuggestedMinimumWidth(), widthMeasureSpec), resolveSize(getSuggestedMinimumHeight(), heightMeasureSpec));
    }

    public void setDotColor(int color) {
        mPath.setColor(color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        float wide = (width / num) * fraction - ((fraction > 1) ? ((fraction - 1) * (width / num) / fraction) : 0);
        float high = height - ((fraction > 1) ? ((fraction - 1) * height / 2 / fraction) : 0);
        for (int i = 0; i < num; i++) {
            float index = 1f + i - (1f + num) / 2;
            float alpha = 255 * (1 - (2 * (Math.abs(index) / num)));
            float x = DensityUtil.px2dp(height);
            mPath.setAlpha((int) (alpha * (1d - 1d / Math.pow((x / 800d + 1d), 15))));
            float radius = mRadius * (1 - 1 / ((x / 10 + 1)));
            canvas.drawCircle(width / 2 - radius / 2 + wide * index, high / 2, radius, mPath);
        }
    }

    public void setFraction(float fraction) {
        this.fraction = fraction;
    }
}
