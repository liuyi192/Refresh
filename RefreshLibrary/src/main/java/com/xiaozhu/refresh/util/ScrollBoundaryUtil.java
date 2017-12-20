package com.xiaozhu.refresh.util;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

/**
 * @说明 滚动边界
 * @作者 LY
 * @时间 2017/12/20 10:12
 * @邮箱 2743569843@qq.com
 * @版权 Copyright(c) 2017 LY-版权所有
 * @备注
 */
public class ScrollBoundaryUtil {

    public static boolean canScrollUp(View targetView, MotionEvent event) {
        if (canScrollUp(targetView)) {
            return true;
        }
        if (targetView instanceof ViewGroup && event != null) {
            ViewGroup viewGroup = (ViewGroup) targetView;
            final int childCount = viewGroup.getChildCount();
            PointF point = new PointF();
            for (int i = childCount; i > 0; i--) {
                View child = viewGroup.getChildAt(i - 1);
                if (isTransformedTouchPointInView(viewGroup, child, event.getX(), event.getY(), point)) {
                    event = MotionEvent.obtain(event);
                    event.offsetLocation(point.x, point.y);
                    return canScrollUp(child, event);
                }
            }
        }
        return false;
    }

    public static boolean canScrollUp(View targetView) {
        if (android.os.Build.VERSION.SDK_INT < 14) {
            if (targetView instanceof AbsListView) {
                final AbsListView absListView = (AbsListView) targetView;
                return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
            } else {
                return targetView.getScrollY() > 0;
            }
        } else {
            return targetView.canScrollVertically(-1);
        }
    }

    public static boolean canScrollDown(View targetView, MotionEvent event) {
        if (canScrollDown(targetView)) {
            return true;
        }
        if (targetView instanceof ViewGroup && event != null) {
            ViewGroup viewGroup = (ViewGroup) targetView;
            final int childCount = viewGroup.getChildCount();
            PointF point = new PointF();
            for (int i = 0; i < childCount; i++) {
                View child = viewGroup.getChildAt(i);
                if (isTransformedTouchPointInView(viewGroup, child, event.getX(), event.getY(), point)) {
                    event = MotionEvent.obtain(event);
                    event.offsetLocation(point.x, point.y);
                    return canScrollDown(child, event);
                }
            }
        }
        return false;
    }

    public static boolean canScrollDown(View targetView) {
        if (android.os.Build.VERSION.SDK_INT < 14) {
            if (targetView instanceof AbsListView) {
                final AbsListView absListView = (AbsListView) targetView;
                return absListView.getChildCount() > 0 && (absListView.getLastVisiblePosition() < absListView.getChildCount() - 1 || absListView.getChildAt(absListView.getChildCount() - 1).getBottom() > absListView.getPaddingBottom());
            } else {
                return targetView.getScrollY() < 0;
            }
        } else {
            return targetView.canScrollVertically(1);
        }
    }

    public static boolean pointInView(View view, float localX, float localY, float slop) {
        final float left = -slop;
        final float top = -slop;
        final float width = view.getWidth();
        final float height = view.getHeight();
        return localX >= left && localY >= top && localX < ((width) + slop) && localY < ((height) + slop);
    }

    public static boolean isTransformedTouchPointInView(ViewGroup group, View child, float x, float y, PointF outLocalPoint) {
        final float[] point = new float[2];
        point[0] = x;
        point[1] = y;
        transformPointToViewLocal(group, child, point);
        final boolean isInView = pointInView(child, point[0], point[1], 0);
        if (isInView && outLocalPoint != null) {
            outLocalPoint.set(point[0] - x, point[1] - y);
        }
        return isInView;
    }

    public static void transformPointToViewLocal(ViewGroup group, View child, float[] point) {
        point[0] += group.getScrollX() - child.getLeft();
        point[1] += group.getScrollY() - child.getTop();
    }
}
