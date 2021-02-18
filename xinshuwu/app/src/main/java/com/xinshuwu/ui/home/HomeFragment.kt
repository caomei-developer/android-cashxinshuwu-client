package com.xinshuwu.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xinshuwu.R
import com.xinshuwu.base.BaseFragment
import com.xinshuwu.ui.home.adapter.TabAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        view_pager.adapter = TabAdapter(childFragmentManager)
        tab.setupWithViewPager(view_pager)
        view_pager.offscreenPageLimit = 3
    }

}