package com.xinshuwu.banner.model

import com.xinshuwu.banner.bean.BannerInfos
import com.xinshuwu.banner.contract.BannerContract
import com.xinshuwu.net.HttpUtil
import com.xinshuwu.net.Response
import io.reactivex.rxjava3.core.Observable

class BannerModel : BannerContract.BannerModel {
    override fun bannersResponse(): Observable<Response<MutableList<BannerInfos>>> {
        return HttpUtil().apiConstant().banners()
    }
}