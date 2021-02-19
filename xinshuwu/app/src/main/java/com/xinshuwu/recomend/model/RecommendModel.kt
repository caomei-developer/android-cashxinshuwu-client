package com.xinshuwu.recomend.model

import com.xinshuwu.XswApplication
import com.xinshuwu.net.APIConstant
import com.xinshuwu.net.HttpUtil
import com.xinshuwu.net.Response
import com.xinshuwu.recomend.bean.Recommends
import com.xinshuwu.recomend.contract.RecommendContract
import com.xinshuwu.util.DeviceUtil
import io.reactivex.rxjava3.core.Observable

class RecommendModel : RecommendContract.RecommendModel {
    override fun RecommendResponse(
        timestamp: Long,
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
                APIConstant().APP_ANDROID,
                timestamp,
                sign,
                page,
                uID,
                token,
                country,
                province,
                city,
                isWifi,
                DeviceUtil.getPhoneName(),
                "WANDOUJIA", DeviceUtil.getImei(XswApplication.instance()),
                DeviceUtil.getAndroidId(XswApplication.context)
            )
    }

}