package com.xinshuwu.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class CustomizedViewPager extends ViewPager {
    private boolean noScroll = false;

    public CustomizedViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomizedViewPager(Context context) {
        super(context);
    }

    public void disableScroll() {
        this.noScroll = true;
    }

    public void enableScroll() {
        this.noScroll = false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (noScroll) {
            return false;
        } else {
            return super.onTouchEvent(arg0);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (noScroll) {
            return false;
        } else {
            return super.onInterceptTouchEvent(arg0);
        }
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }
}
