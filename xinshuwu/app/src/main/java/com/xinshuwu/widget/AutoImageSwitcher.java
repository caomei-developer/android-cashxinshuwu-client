package com.xinshuwu.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.squareup.picasso.Picasso;
import com.xinshuwu.R;
import com.xinshuwu.XswApplication;
import com.xinshuwu.util.DeviceUtil;
import com.xinshuwu.util.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class AutoImageSwitcher extends RelativeLayout implements View.OnClickListener {

    private float ratio = -1.0f;

    private boolean autoSwitch = true;

    private CustomizedViewPager viewPager;

    private ImageAdapter imageAdapter;

    private PagerIndicator pagerIndicator;

    private List<String> imageUrls = null;

    private LinkedList<View> mViews;

    private Callback callback;

    private Queue<ImageView> imageViewCache = new LinkedBlockingQueue<ImageView>();

    private boolean finished = false;

    protected int targetImageWidth = 0;

    public void setFinished() {
        this.finished = true;
        removeCallbacks(runnable);
    }

    public void setPaused(boolean paused) {
        removeCallbacks(runnable);
        if (!paused) {
            postDelayed(runnable, TRANSITION_INTERVAL);
        }
    }

    public AutoImageSwitcher(Context context) {
        this(context, null, 0);
    }

    public AutoImageSwitcher(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoImageSwitcher(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.AutoImageSwitcher);
        ratio = mTypedArray.getFloat(R.styleable.AutoImageSwitcher_ratios, -1.0f);
        autoSwitch = mTypedArray.getBoolean(R.styleable.AutoImageSwitcher_auto_switch, true);
        mTypedArray.recycle();
        intViews();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        if (ratio > 0) {
            int heightSize = (int) (widthSize / ratio);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize, MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void intViews() {
        viewPager = new CustomizedViewPager(getContext());
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        this.addView(viewPager, layoutParams);
        viewPager.addOnPageChangeListener(listener);
    }

    private ImageView selectOneImageView() {
        ImageView imageView = imageViewCache.poll();
        if (imageView == null) {
            imageView = new ImageView(getContext());
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            imageView.setOnClickListener(this);
        }
        return imageView;
    }

    public void setImages(List<String> imageUrls) {
        if (imageUrls == null || imageUrls.size() == 0) {
            return;
        }
        Utils.setBackground(this, null);
        this.imageUrls = imageUrls;
        initImageViews();
        imageAdapter = new ImageAdapter();
        viewPager.setAdapter(imageAdapter);
        viewPager.setCurrentItem(1);
        if (callback != null) {
            if (imageUrls.size() == 1) {
                callback.onPageSelected(0);
            }
        }
        for (int i = 0; i < this.getChildCount(); ++i) {
            View view = this.getChildAt(i);
            if (view instanceof PagerIndicator) {
                if (imageUrls.size() > 1) {
                    pagerIndicator = (PagerIndicator) view;
                    view.setVisibility(VISIBLE);
                    viewPager.enableScroll();
                } else {
                    view.setVisibility(GONE);
                    viewPager.disableScroll();
                }
                break;
            }
        }
        if (pagerIndicator != null) {
            pagerIndicator.setTotal(imageUrls.size());
            pagerIndicator.setCurrent(1);
        }
    }

    private void initImageViews() {
        if (imageUrls != null) {
            mViews = new LinkedList<>();
            String imageUrl = imageUrls.get(imageUrls.size() - 1);
            ImageView imageView = selectOneImageView();
            imageView.setTag(imageUrls.size() - 1);
            Picasso.with(getContext()).load(imageUrl).into(imageView);
            mViews.add(imageView);
            if (imageUrls.size() > 1) {
                for (int i = 0; i < imageUrls.size(); i++) {
                    imageUrl = imageUrls.get(i);
                    imageView = selectOneImageView();
                    imageView.setTag(i);
                    Picasso.with(getContext()).load(imageUrl).into(imageView);
                    mViews.add(imageView);
                }
                imageUrl = imageUrls.get(0);
                imageView = selectOneImageView();
                Picasso.with(getContext()).load(imageUrl).into(imageView);
                mViews.add(imageView);
            }
        }
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onClick(View v) {
        Integer position = (Integer) v.getTag();
        if (position != null && callback != null) {
            callback.onClick(position);
        }
    }

    private class ImageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if (mViews != null && mViews.size() > 0) {
                View view = mViews.get(position);
                if (view.getParent() == null) {
                    container.addView(view);
                }
                return view;
            }
            return null;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ImageView imageView = (ImageView) object;
            container.removeView(imageView);
            imageViewCache.add(imageView);
        }
    }

    private long lastSwitchTime = 0;

    private ViewPager.SimpleOnPageChangeListener listener = new ViewPager.SimpleOnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            lastSwitchTime = System.currentTimeMillis();
            if (pagerIndicator != null) {
                if (position != 0 && position != mViews.size() - 1) {
                    pagerIndicator.setCurrent(position);
                } else {
                    if (position == 0) {
                        pagerIndicator.setCurrent(mViews.size() - 2);
                    } else {
                        pagerIndicator.setCurrent(1);
                    }
                }
            }
            if (callback != null) {
                if (position == 0 || position == mViews.size() - 1) {
                    return;
                }
                callback.onPageSelected(position - 1);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == ViewPager.SCROLL_STATE_IDLE) {
                if (viewPager.getCurrentItem() == 0) {
                    viewPager.setCurrentItem(imageAdapter.getCount() - 2, false);
                } else if (viewPager.getCurrentItem() == viewPager.getAdapter().getCount() - 1) {
                    viewPager.setCurrentItem(1, false);
                }
            }
        }
    };

    private Runnable runnable = new Runnable() {

        @Override
        public void run() {
            if (autoSwitch && !finished) {
                long currentTime = System.currentTimeMillis();
                if (currentTime < lastSwitchTime + (TRANSITION_INTERVAL - 1000)) {
                    postDelayed(runnable, lastSwitchTime + TRANSITION_INTERVAL - currentTime);
                } else {
                    if (imageAdapter != null && imageAdapter.getCount() > 1) {
                        int index = viewPager.getCurrentItem();
                        viewPager.setCurrentItem(index % imageAdapter.getCount() + 1, true);
                    }
                    postDelayed(runnable, TRANSITION_INTERVAL);
                }
            }
        }
    };

    public static interface Callback {

        public void onClick(int position);

        public void onPageSelected(int position);
    }

    protected int getImageWidth() {
        if (targetImageWidth > 50) {
            return targetImageWidth;
        }
        int screenWidth = DeviceUtil.getScreenWidth(XswApplication.Companion.instance());
        targetImageWidth = (int) (screenWidth / 1.5);
        if (targetImageWidth > 600) {
            targetImageWidth = 600;
        }
        return targetImageWidth;
    }

    private static final int TRANSITION_INTERVAL = 5000;

}
