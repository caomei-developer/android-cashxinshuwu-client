package com.xinshuwu.detail.presenter

import com.xinshuwu.base.BasePresenter
import com.xinshuwu.detail.bean.BookDetail
import com.xinshuwu.detail.contract.BookDetailContract
import com.xinshuwu.detail.model.BookDetailModel
import com.xinshuwu.net.Response
import com.xinshuwu.net.RxScheduler
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


class BookDetailPresenter : BasePresenter<BookDetailContract.View>(), BookDetailContract.Presenter {

    private val bookDetailModel: BookDetailContract.BookDetaolModel = BookDetailModel()

    override fun BookDetaolPresenter(
        timestamp: Long,
        sign: String,
        bId: String,
        lmId: String,
        token: String,
        uId: String
    ) {
        if (!isViewAttached()) {
            return
        }
        bookDetailModel.bookResponse(
            timestamp, sign, bId, lmId, token, uId
        ).compose(RxScheduler().observableTransformer())
            .to(mView!!.bindAutoDispose())
            .subscribe(object : Observer<Response<BookDetail>> {
                override fun onComplete() {
                    mView!!.hideLoading()
                }

                override fun onSubscribe(d: Disposable?) {
                    mView!!.showLoading()
                }

                override fun onNext(t: Response<BookDetail>?) {
                    mView!!.onSuccess(t!!.DATA)
                    mView!!.hideLoading()
                }

                override fun onError(e: Throwable?) {
                    mView!!.onError(e!!.message)
                    mView!!.hideLoading()
                }

            })

    }
}