package com.xinshuwu.util

import android.content.Context

class ThemeUtil {
    private val APPCOMPAT_CHECK_ATTRS = intArrayOf(androidx.appcompat.R.attr.colorPrimary)

    fun checkAppCompatTheme(context: Context) {
        val a = context.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS)
        val failed = !a.hasValue(0)
        a?.recycle()
        require(!failed) { "You need to use a Theme.AppCompat theme " + "(or descendant) with the design library." }
    }
}