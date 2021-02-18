package com.xinshuwu.schoolboy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xinshuwu.R
import com.xinshuwu.base.BaseFragment

class SchoolboyFragment : BaseFragment() {

    fun newInstance(): SchoolboyFragment {

        val args = Bundle()

        val fragment = SchoolboyFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_girl_student, container, false)
    }
}