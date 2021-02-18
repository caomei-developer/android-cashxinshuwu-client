package com.xinshuwu.girlstudent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xinshuwu.R
import com.xinshuwu.base.BaseFragment

class GirlStudentFragment : BaseFragment() {

    fun newInstance(): GirlStudentFragment {

        val args = Bundle()

        val fragment = GirlStudentFragment()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}