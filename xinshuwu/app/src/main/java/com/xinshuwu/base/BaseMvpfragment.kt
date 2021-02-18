package com.xinshuwu.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import autodispose2.AutoDispose
import autodispose2.AutoDisposeConverter
import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider

open class BaseMvpfragment<V : BaseView, T : BasePresenter<V>> : BaseFragment() {
    protected var mPresenter: T? = null

    override fun onDestroyView() {
        super.onDestroyView()
        if (mPresenter != null) {
            mPresenter!!.detachView()
        }
        super.onDestroyView()
    }


    override fun needSetVisibleHintManually(): Boolean {
        return true
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (this.isAdded) {
            val fragmentManager = this.childFragmentManager
            if (fragmentManager != null) {
                val fragments = fragmentManager.fragments
                if (fragments != null && fragments.isNotEmpty()) {
                    val var4 = fragments.iterator()

                    while (var4.hasNext()) {
                        val fragment = var4.next() as Fragment
                        fragment.userVisibleHint = isVisibleToUser
                    }
                }
            }
        }

    }

    fun <T> bindAutoDispose(): AutoDisposeConverter<T> {
        return AutoDispose.autoDisposable(
            AndroidLifecycleScopeProvider.from(
                this,
                Lifecycle.Event.ON_DESTROY
            )
        )
    }
}