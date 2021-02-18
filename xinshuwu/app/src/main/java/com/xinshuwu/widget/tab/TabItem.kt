package com.xinshuwu.widget.tab

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import com.xinshuwu.R

class TabItem : View {
    var mText: CharSequence? = null
    var mIcon: Drawable? = null
    var mCustomLayout: Int = 0


    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        var typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.TabItem)
        mText = typedArray.getText(R.styleable.TabItem_android_text)
        mIcon = typedArray.getDrawable(R.styleable.TabItem_android_icon)
        mCustomLayout = typedArray.getResourceId(R.styleable.TabItem_android_layout, 0)
        typedArray.recycle()

    }
}