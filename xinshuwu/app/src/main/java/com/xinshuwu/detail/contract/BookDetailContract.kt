package com.xinshuwu.detail.contract

import com.xinshuwu.base.BaseView
import com.xinshuwu.detail.bean.BookDetail
import com.xinshuwu.net.Response
import io.reactivex.rxjava3.core.Observable

class BookDetailContract {
    interface BookDetaolModel {
        fun bookResponse(
            timestamp: Long,
            sign: String,
            bId: String,
            lmId: String,
            token: String,
            uId: String
        ): Observable<Response<BookDetail>>
    }

    interface View : BaseView {
        fun onSuccess(bookDetail: BookDetail)
    }

    interface Presenter {
        fun BookDetaolPresenter(
            timestamp: Long,
            sign: String,
            bId: String,
            lmId: String,
            token: String,
            uId: String
        )
    }

}