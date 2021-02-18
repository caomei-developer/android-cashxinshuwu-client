package com.xinshuwu.recomend.contract

import com.xinshuwu.base.BaseView
import com.xinshuwu.net.Response
import com.xinshuwu.recomend.bean.LMLIST
import com.xinshuwu.recomend.bean.Recommends
import io.reactivex.rxjava3.core.Observable

class RecommendContract {
    interface RecommendModel {
        fun RecommendResponse(
            timestamp: String,
            sign: String,
            page: String,
            uID: String,
            token: String,
            country: String,
            province: String,
            city: String,
            isWifi: String
        ): Observable<Response<Recommends>>
    }

    interface View : BaseView {
        fun onSuccess(lmlist: List<LMLIST>)
    }

    interface Presenter {
        fun RecommendsPresenter(
            timestamp: String,
            sign: String,
            page: String,
            uID: String,
            token: String,
            country: String,
            province: String,
            city: String,
            isWifi: String
        )
    }
}