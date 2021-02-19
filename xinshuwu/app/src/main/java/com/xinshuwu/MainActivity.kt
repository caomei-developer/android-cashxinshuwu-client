package com.xinshuwu

import android.Manifest
import android.os.Bundle
import com.tbruyelle.rxpermissions2.Permission
import com.tbruyelle.rxpermissions2.RxPermissions
import com.xinshuwu.base.TabActivity
import com.xinshuwu.ui.dashboard.DashboardFragment
import com.xinshuwu.ui.home.HomeFragment
import com.xinshuwu.ui.notifications.NotificationsFragment
import com.xinshuwu.util.CompatUtil
import io.reactivex.rxjava3.functions.Consumer


class MainActivity : TabActivity() {
    private val tabItemList: MutableList<TabItem> = arrayListOf()

    private val viewPagerFragmentList: MutableList<PagerFragment>? = arrayListOf()

    override fun hasToolbar(): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTabBar()
        initViewPager()

        checkPermissions()
    }

    private fun checkPermissions() {
        RxPermissions(this).requestEach(
            Manifest.permission.READ_PHONE_STATE
        ).subscribe {
            Consumer<Permission> { t ->
                if (t.granted) {
                }
            }
        }
    }

    private fun initViewPager() {
        val bundle = Bundle()
        viewPagerFragmentList!!.apply {
            viewPagerFragmentList.add(PagerFragment(HomeFragment::class.java, bundle))
            viewPagerFragmentList.add(PagerFragment(DashboardFragment::class.java, bundle))
            viewPagerFragmentList.add(PagerFragment(NotificationsFragment::class.java, bundle))
            setPagerFragmentList(viewPagerFragmentList)
            viewPager!!.offscreenPageLimit = 3
        }

    }

    //bfbfbf
    //d81e06

    private fun initTabBar() {
        tabItemList!!.apply {
            tabItemList.add(
                TabItem(
                    "小说",
                    CompatUtil.getDrawable(this@MainActivity, R.mipmap.tabbar_home_normal_icon),
                    CompatUtil.getDrawable(this@MainActivity, R.mipmap.tabbar_home_selected_icon),
                    false
                )
            )

            tabItemList.add(
                TabItem(
                    "漫画",
                    CompatUtil.getDrawable(
                        this@MainActivity,
                        R.mipmap.tabbar_home_normal_icon
                    ),
                    CompatUtil.getDrawable(
                        this@MainActivity,
                        R.mipmap.tabbar_home_selected_icon
                    ),
                    false
                )
            )



            tabItemList.add(
                TabItem(
                    "我的",
                    CompatUtil.getDrawable(
                        this@MainActivity,
                        R.mipmap.tabbar_home_normal_icon
                    ),
                    CompatUtil.getDrawable(
                        this@MainActivity,
                        R.mipmap.tabbar_home_selected_icon
                    ),
                    false
                )
            )
            setTabItemList(tabItemList)
        }

    }


}
