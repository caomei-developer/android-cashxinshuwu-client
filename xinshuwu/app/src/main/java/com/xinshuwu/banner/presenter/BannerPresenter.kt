package com.xinshuwu.banner.presenter

import com.xinshuwu.banner.bean.BannerInfos
import com.xinshuwu.banner.contract.BannerContract
import com.xinshuwu.banner.model.BannerModel
import com.xinshuwu.base.BasePresenter
import com.xinshuwu.net.Response
import com.xinshuwu.net.RxScheduler
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class BannerPresenter : BasePresenter<BannerContract.View>(), BannerContract.BannerPresenter {
    private var bannerModel: BannerContract.BannerModel = BannerModel()

    override fun banners() {
        if (!isViewAttached()) {
            return
        }
        bannerModel.bannersResponse().compose(RxScheduler().observableTransformer())
            .to(mView!!.bindAutoDispose())
            .subscribe(object : Observer<Response<MutableList<BannerInfos>>> {
                override fun onComplete() {
                    mView!!.hideLoading()
                }

                override fun onSubscribe(d: Disposable?) {
                    mView!!.showLoading()
                }

                override fun onNext(t: Response<MutableList<BannerInfos>>?) {
                    mView!!.onSuccess(t!!.data)
                    mView!!.hideLoading()
                }

                override fun onError(e: Throwable?) {
                    mView!!.onError(e!!.message)
                    mView!!.hideLoading()
                }

            })
    }
}