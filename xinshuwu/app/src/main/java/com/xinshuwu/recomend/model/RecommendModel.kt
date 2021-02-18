package com.xinshuwu.recomend.model

import com.xinshuwu.XswApplication
import com.xinshuwu.net.HttpUtil
import com.xinshuwu.net.Response
import com.xinshuwu.recomend.bean.Recommends
import com.xinshuwu.recomend.contract.RecommendContract
import com.xinshuwu.util.DeviceUtil
import io.reactivex.rxjava3.core.Observable

class RecommendModel : RecommendContract.RecommendModel {
    override fun RecommendResponse(
        timestamp: String,
        sign: String,
        page: String,
        uID: String,
        token: String,
        country: String,
        province: String,
        city: String,
        isWifi: String
    ): Observable<Response<Recommends>> {
        return HttpUtil().apiFzConstant()
            .recommends(
                timestamp,
                sign,
                page,
                uID,
                token,
                country,
                province,
                city,
                isWifi,
                DeviceUtil.getModel(),
                "WANDOUJIA", DeviceUtil.getImei(XswApplication.context),
                DeviceUtil.getAndroidId(XswApplication.context)
            )
    }

}