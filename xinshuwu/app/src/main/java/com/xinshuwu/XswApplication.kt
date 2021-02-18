package com.xinshuwu

import android.app.Application

open class XswApplication : Application() {

    companion object {
        var context: XswApplication? = null

        fun instance() = context!!
    }


    override fun onCreate() {
        super.onCreate()
        context = this
    }
}