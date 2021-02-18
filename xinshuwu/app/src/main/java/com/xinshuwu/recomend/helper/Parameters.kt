package com.xinshuwu.recomend.helper

import com.xinshuwu.util.ApiRequestUtil


class Parameters {

    fun map(
        timestamp: Long,
        param: String,
        fuJingXuan: String,
        UID: String,
        token: String,
        country: String,
        province: String,
        city: String,
        isWifi: String
    ): Map<String, Any>? {
        return ApiRequestUtil().buildMap(
            "timestamp",
            timestamp,
            "sign",
            param,
            "page",
            fuJingXuan,
            "uID",
            UID,
            "token",
            token,
            "country",
            country,
            "province",
            province,
            "city",
            city,
            "isWifi",
            isWifi
        )

    }

}