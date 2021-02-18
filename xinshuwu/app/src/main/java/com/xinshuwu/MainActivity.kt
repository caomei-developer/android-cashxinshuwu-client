package com.xinshuwu

import android.os.Bundle
import com.xinshuwu.base.TabActivity
import com.xinshuwu.ui.dashboard.DashboardFragment
import com.xinshuwu.ui.home.HomeFragment
import com.xinshuwu.ui.notifications.NotificationsFragment
import com.xinshuwu.util.CompatUtil

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
