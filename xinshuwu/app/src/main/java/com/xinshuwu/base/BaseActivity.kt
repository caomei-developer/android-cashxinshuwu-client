package com.xinshuwu.base

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.xinshuwu.R
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseActivity : AppCompatActivity() {

    private var inflater: LayoutInflater? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inflater = LayoutInflater.from(this)

    }

    override fun setContentView(layoutResID: Int) {


        if (hasToolbar()) {
            super.setContentView(R.layout.activity_base)
            inflater!!.inflate(layoutResID, content_view, true)

            close.setOnClickListener {
                finish()
            }
            init()
        } else {
            super.setContentView(layoutResID)
        }

    }

    open fun init() {
        try {
            title_name.text =
                packageManager.getActivityInfo(this.componentName, 0).loadLabel(packageManager)
                    .toString()

        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }


    }


    abstract fun hasToolbar(): Boolean

}