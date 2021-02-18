package com.xinshuwu.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.xinshuwu.girlstudent.GirlStudentFragment
import com.xinshuwu.recomend.RecommendFragment
import com.xinshuwu.schoolboy.SchoolboyFragment

class TabAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val title = arrayOf("推荐", "男生", "女生")


    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return RecommendFragment().newInstance()
            }
            1 -> {
                return SchoolboyFragment().newInstance()
            }
            2 -> {
                return GirlStudentFragment().newInstance()
            }
            else -> {
                return RecommendFragment().newInstance()
            }
        }

    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

}