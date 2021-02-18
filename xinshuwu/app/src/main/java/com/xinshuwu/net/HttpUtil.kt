package com.xinshuwu.net

class HttpUtil {
    fun apiConstant(): ApiService {
        return RetrofitClient().instance()!!.retrofit(RetrofitClient.apiToUrl.IQ)!!.create(
            ApiService::class.java
        )
    }

    fun apiFzConstant(): ApiService {
        return RetrofitClient().instance()!!.retrofit(RetrofitClient.apiToUrl.FZ)!!.create(
            ApiService::class.java
        )
    }
}