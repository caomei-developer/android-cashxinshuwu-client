package com.xinshuwu.detail

import android.os.Bundle
import com.xinshuwu.R
import com.xinshuwu.base.BaseActivity

class NovelDetailActivity : BaseActivity() {
    override fun hasToolbar(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.novel_detail_activity)
    }
}