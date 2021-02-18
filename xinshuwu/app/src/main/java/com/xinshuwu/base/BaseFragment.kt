package com.xinshuwu.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (needSetVisibleHintManually()) {
            userVisibleHint = userVisibleHint
        }

    }

    open fun needSetVisibleHintManually(): Boolean {
        return true
    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isAdded) {
            val fragmentManager = childFragmentManager
            if (fragmentManager != null) {
                val fragments = fragmentManager.fragments
                if (fragments != null && !fragments.isEmpty()) {
                    for (fragment in fragments) {
                        fragment.userVisibleHint = isVisibleToUser
                    }
                }
            }
        }
    }
}