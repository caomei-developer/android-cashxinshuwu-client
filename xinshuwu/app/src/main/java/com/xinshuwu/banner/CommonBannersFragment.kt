package com.xinshuwu.banner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xinshuwu.R
import com.xinshuwu.banner.helper.BannersHelper
import com.xinshuwu.base.BaseFragment
import com.xinshuwu.widget.AutoImageSwitcher
import com.xinshuwu.widget.compoment.pager.DotPageIndicator


class CommonBannersFragment : BaseFragment() {

    protected var bannerSwitcher: AutoImageSwitcher? = null
    protected lateinit var dotPageIndicator: DotPageIndicator
    protected var bannerViewHelper: BannersHelper? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (getLayoutId() == -1) {
            return inflater.inflate(R.layout.banner_fragment, container, false)
        }
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        userVisibleHint = true
        if (bannerSwitcher == null) {
            bannerSwitcher = view.findViewById<View>(R.id.image_switcher) as AutoImageSwitcher
            dotPageIndicator = view.findViewById<View>(R.id.dotPageIndicator) as DotPageIndicator
            bannerViewHelper =
                BannersHelper(
                    bannerSwitcher!!,
                    dotPageIndicator,
                    getBannerLocation(),
                    activity!!,
                    3
                )
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && bannerViewHelper != null) {
            load()
        }
        if (bannerSwitcher != null) {
            bannerSwitcher!!.setPaused(!isVisibleToUser)
        }
    }

    private fun load() {
        bannerViewHelper!!.getBannerA(object : BannersHelper.CallBack {
            override fun onSuccess() {
                onLoaded(false)
            }

            override fun onError() {
                onLoaded(true)

            }
        })
    }


    protected fun getBannerLocation(): Int {
        return 0
    }

    protected fun onLoaded(isEmpty: Boolean) {

    }


    override fun onDestroy() {
        super.onDestroy()
        if (bannerSwitcher != null) {
            bannerSwitcher!!.setFinished()
        }
    }

    override fun onPause() {
        super.onPause()
        if (bannerSwitcher != null) {
            bannerSwitcher!!.setPaused(true)
        }
    }

    override fun onResume() {
        super.onResume()
        if (bannerSwitcher != null) {
            bannerSwitcher!!.setPaused(false)
        }
    }


    private fun getLayoutId(): Int {
        return -1
    }


}