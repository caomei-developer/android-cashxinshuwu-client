package com.xinshuwu.widget.compoment;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.xinshuwu.R;


public class RoundImageView extends AppCompatImageView {

	private float radius = 0f;

	public RoundImageView(Context context) {
		this(context, null);
	}

	public RoundImageView(Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public RoundImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundImageView);
		try {
			radius = typedArray.getDimension(R.styleable.RoundImageView_radius, 0f);
		} finally {
			typedArray.recycle();
		}
	}

	@Override
	public void setImageDrawable(@Nullable Drawable drawable) {
		Drawable newDrawable = drawable;
		if (drawable instanceof BitmapDrawable) {
			newDrawable = RoundedBitmapDrawableFactory.create(getResources(), ((BitmapDrawable) drawable).getBitmap());
		} else if (drawable instanceof ColorDrawable) {
			newDrawable = new RoundColorDrawable(((ColorDrawable) drawable).getColor());
		}
		super.setImageDrawable(newDrawable);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if (getDrawable() != null)
			if (getDrawable() instanceof RoundedBitmapDrawable) {
				RoundedBitmapDrawable roundedBitmapDrawable = (RoundedBitmapDrawable) getDrawable();
				roundedBitmapDrawable.setCornerRadius(radius * roundedBitmapDrawable.getIntrinsicWidth() / getWidth());
			} else if (getDrawable() instanceof RoundColorDrawable) {
				RoundColorDrawable roundColorDrawable = (RoundColorDrawable) getDrawable();
				roundColorDrawable.setRadius(radius);
			}
		super.onDraw(canvas);
	}
}
