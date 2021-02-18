package com.xinshuwu.util

import com.xinshuwu.XswApplication
import java.util.*

class ApiRequestUtil {
    fun fixedMap(vararg values: String): Map<String, String> {
        val map = HashMap<String, String>()
        map["consumerKey"] = "FUZHU_ANDROID"
        map["mType"] = DeviceUtil.getModel()
        map["PACKINGCHANNEL"] = "WANDOUJIA"
        map["imei"] = DeviceUtil.getImei(XswApplication.instance())
        map["androidID"] = DeviceUtil.getAndroidId(XswApplication.instance())

        var i = 0
        while (i < values.size) {
            map[values[i]] = values[i + 1]
            i += 2
        }
        return map
    }

    fun buildMap(vararg keyValues: Any): Map<String, Any> {
        val resultMap = HashMap<String, Any>()
        var i = 0
        while (i < keyValues.size) {
            resultMap[keyValues[i] as String] = keyValues[i + 1]
            i += 2
        }
        return resultMap
    }
}

