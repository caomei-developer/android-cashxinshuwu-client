package com.xinshuwu.banner.contract

import com.xinshuwu.banner.bean.BannerInfos
import com.xinshuwu.base.BaseView
import com.xinshuwu.net.Response
import io.reactivex.rxjava3.core.Observable

class BannerContract {
    interface BannerModel {
        fun bannersResponse(): Observable<Response<MutableList<BannerInfos>>>
    }

    interface View : BaseView {
        fun onSuccess(banners: MutableList<BannerInfos>)
    }

    interface BannerPresenter {
        fun banners()
    }
}