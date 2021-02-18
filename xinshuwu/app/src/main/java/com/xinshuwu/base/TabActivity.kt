package com.xinshuwu.base

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.xinshuwu.R
import com.xinshuwu.widget.CustomViewPager
import com.xinshuwu.widget.compoment.Tabbar

open class TabActivity : BaseActivity() {

    protected var tabbar: Tabbar? = null

    protected var viewPager: CustomViewPager? = null

    override fun hasToolbar(): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)
        tabbar = findViewById(R.id.tabbar)
        viewPager = findViewById(R.id.viewpager)
        viewPager!!.isScrollble = false
        linkTabbarAndViewpager()
    }

    protected fun setTabItemList(tabItemList: MutableList<TabItem>) {
        tabbar!!.setAdapter(TabItemArrayAdapter(tabItemList))
    }

    fun onRefresh() {
        viewPager!!.getAdapter()!!.notifyDataSetChanged()
    }

    protected fun setPagerFragmentList(viewPagerFragmentList: List<PagerFragment>) {
        viewPager!!.setAdapter(PagerFragmentArrayAdapter(this, viewPagerFragmentList))
    }


    private fun linkTabbarAndViewpager() {
        tabbar!!.addListener {
            viewPager!!.setCurrentItem(it, false)
            viewPager!!.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
                override fun onPageSelected(position: Int) {
                    tabbar!!.select(position)
                }
            })
        }

    }


    protected class TabItem(
        var title: String?,
        var normalIcon: Drawable?,
        var selectedIcon: Drawable?,
        private var reminder: Boolean
    ) {

        fun hasReminder(): Boolean {
            return reminder
        }

        fun setReminder(reminder: Boolean) {
            this.reminder = reminder
        }
    }

    protected class TabItemArrayAdapter constructor(tabItemList: MutableList<TabItem>) :
        Tabbar.Adapter {

        private var tabItemList: MutableList<TabItem>? = null

        init {
            this.tabItemList = tabItemList
        }

        override fun getCount(): Int {
            return tabItemList!!.size
        }

        override fun getTitle(index: Int): String {
            return tabItemList!![index].title!!
        }

        override fun getNormalIcon(index: Int): Drawable {
            return tabItemList!![index].normalIcon!!
        }

        override fun getSelectedIcon(index: Int): Drawable {
            return tabItemList!![index].selectedIcon!!
        }


        override fun hasReminder(index: Int): Boolean {
            return tabItemList!![index].hasReminder()
        }

    }


    protected class PagerFragment(fragmentClass: Class<out BaseFragment>, arguments: Bundle) {

        private var fragmentClass: Class<out BaseFragment>? = null
        private var arguments: Bundle? = null

        init {
            this.fragmentClass = fragmentClass
            this.arguments = arguments
        }

        fun getFragmentClass(): Class<out BaseFragment> {
            return fragmentClass!!
        }

        fun setFragmentClass(fragmentClass: Class<out BaseFragment>) {
            this.fragmentClass = fragmentClass
        }

        fun getArguments(): Bundle? {
            return arguments
        }

        fun setArguments(arguments: Bundle) {
            this.arguments = arguments
        }
    }

    private class PagerFragmentArrayAdapter(
        private val activity: TabActivity,
        private val viewPagerFragmentList: List<PagerFragment>
    ) :
        FragmentPagerAdapter(activity.supportFragmentManager) {

        override fun getItem(position: Int): Fragment {
            return Fragment.instantiate(
                activity, viewPagerFragmentList[position].getFragmentClass().name,
                viewPagerFragmentList[position].getArguments()
            )
        }

        override fun getCount(): Int {
            return viewPagerFragmentList.size
        }

    }

}