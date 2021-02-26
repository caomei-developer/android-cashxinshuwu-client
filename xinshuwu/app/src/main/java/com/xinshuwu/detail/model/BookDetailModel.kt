package com.xinshuwu.detail.model

import com.xinshuwu.XswApplication
import com.xinshuwu.detail.bean.BookDetail
import com.xinshuwu.detail.contract.BookDetailContract
import com.xinshuwu.net.APIConstant
import com.xinshuwu.net.HttpUtil
import com.xinshuwu.net.Response
import com.xinshuwu.util.DeviceUtil
import io.reactivex.rxjava3.core.Observable

class BookDetailModel : BookDetailContract.BookDetaolModel {
    override fun bookResponse(
        timestamp: Long,
        sign: String,
        bId: String,
        lmId: String,
        token: String,
        uId: String
    ): Observable<Response<BookDetail>> {
        return HttpUtil().apiFzConstant().bookDetail(
            APIConstant().APP_ANDROID, timestamp, sign, bId, lmId, uId, "0",
            DeviceUtil.getImei(XswApplication.instance()),
            DeviceUtil.getAndroidId(XswApplication.context)
        )
    }
}