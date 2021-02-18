package com.xinshuwu.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xinshuwu.R
import com.xinshuwu.base.BaseMvpfragment
import com.xinshuwu.hot.contract.HotContract
import com.xinshuwu.hot.presenter.HotPresenter

class DashboardFragment : BaseMvpfragment<HotContract.View, HotPresenter>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }
}