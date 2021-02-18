package com.xinshuwu.hot.contract

import com.xinshuwu.base.BaseView
import com.xinshuwu.hot.bean.Hot
import com.xinshuwu.net.Response
import io.reactivex.rxjava3.core.Observable

class HotContract {

    interface HotModel {
        fun hotResponse(): Observable<Response<MutableList<Hot>>>?
    }

    interface View : BaseView {
        fun onSuccess(hot: MutableList<Hot>)
    }

    public interface Presenter {
        fun hot()
    }

}