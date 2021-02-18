package com.xinshuwu.hot.presenter

import com.xinshuwu.base.BasePresenter
import com.xinshuwu.hot.bean.Hot
import com.xinshuwu.hot.contract.HotContract
import com.xinshuwu.hot.model.HotModel
import com.xinshuwu.net.Response
import com.xinshuwu.net.RxScheduler
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class HotPresenter : BasePresenter<HotContract.View>(), HotContract.Presenter {

    private var hotModel: HotContract.HotModel = HotModel()


    override fun hot() {
        if (!isViewAttached()) {
            return
        }
        hotModel.hotResponse()!!.compose(RxScheduler().observableTransformer())
            .to(mView!!.bindAutoDispose())
            .subscribe(object : Observer<Response<MutableList<Hot>>> {
                override fun onNext(t: Response<MutableList<Hot>>?) {
                    mView!!.onSuccess(t!!.data)
                }


                override fun onComplete() {
                    mView!!.hideLoading()
                }

                override fun onSubscribe(d: Disposable?) {
                    mView!!.showLoading()
                }


                override fun onError(e: Throwable?) {
                    mView!!.onError(e!!.message)
                    mView!!.hideLoading()
                }

            })
    }
}