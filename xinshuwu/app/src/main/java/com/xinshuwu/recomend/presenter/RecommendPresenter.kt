package com.xinshuwu.recomend.presenter

import com.xinshuwu.base.BasePresenter
import com.xinshuwu.net.Response
import com.xinshuwu.net.RxScheduler
import com.xinshuwu.recomend.bean.Recommends
import com.xinshuwu.recomend.contract.RecommendContract
import com.xinshuwu.recomend.model.RecommendModel
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class RecommendPresenter : BasePresenter<RecommendContract.View>(), RecommendContract.Presenter {

    private val recommendModel: RecommendContract.RecommendModel = RecommendModel()


    override fun RecommendsPresenter(
        timestamp: String,
        sign: String,
        page: String,
        uID: String,
        token: String,
        country: String,
        province: String,
        city: String,
        isWifi: String
    ) {
        if (!isViewAttached()) {
            return
        }

        recommendModel.RecommendResponse(
            timestamp, sign, page, uID, token, country, province, city, isWifi
        ).compose(RxScheduler().observableTransformer())
            .to(mView!!.bindAutoDispose())
            .subscribe(object : Observer<Response<Recommends>> {
                override fun onComplete() {
                    mView!!.hideLoading()
                }

                override fun onSubscribe(d: Disposable?) {
                    mView!!.showLoading()
                }

                override fun onNext(t: Response<Recommends>?) {
                    mView!!.onSuccess(t!!.DATA!!.LMLIST)
                    mView!!.hideLoading()
                }

                override fun onError(e: Throwable?) {
                    mView!!.onError(e!!.message)
                    mView!!.hideLoading()
                }

            })
    }

}