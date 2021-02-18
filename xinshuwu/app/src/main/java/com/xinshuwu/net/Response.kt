package com.xinshuwu.net


data class Response<T>(
    var code: Int,
    var RETCODE: Int,
    var MSG: String,
    var msg: String,
    var data: T,
    var DATA: T
)