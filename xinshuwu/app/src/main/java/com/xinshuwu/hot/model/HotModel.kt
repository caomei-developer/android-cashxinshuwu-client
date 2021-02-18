package com.xinshuwu.hot.model

import com.xinshuwu.hot.bean.Hot
import com.xinshuwu.hot.contract.HotContract
import com.xinshuwu.net.HttpUtil
import com.xinshuwu.net.Response
import io.reactivex.rxjava3.core.Observable

class HotModel : HotContract.HotModel {
    override fun hotResponse(): Observable<Response<MutableList<Hot>>>? {
        return HttpUtil().apiConstant().hotList()
    }
}