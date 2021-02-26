package com.xinshuwu.recomend.bean

import com.xinshuwu.base.AbstractInfoFlow
import com.xinshuwu.base.InfoFlowInterface.LEVEL_TYPE
import com.xinshuwu.base.InfoFlowInterface.VERTICAL_TYPE
import com.xinshuwu.util.StringUtil

class RecommendBookInfoFlow(books: BOOKS) : AbstractInfoFlow<BOOKS>() {

    init {
        materialObj = books
    }

    override fun getBookAuthor(): String {
        return materialObj!!.AUTHORNAME
    }

    override fun getBookCategory(): String {

        return materialObj!!.KEYTYPE
    }

    override fun getBookDesc(): String {
        return if (materialObj!!.CONTENT.isEmpty()) "暂无" else materialObj!!.CONTENT
    }

    override fun getBookImage(): String {
        return materialObj!!.COVERURL
    }

    override fun getBookName(): String {
        return materialObj!!.KEYNAME
    }

    override fun getBookScore(): String {
        return ""
    }

    override fun getBookWordNum(): Int {
        if (materialObj != null && materialObj!!.WORDNUM > 0) {
            return materialObj!!.WORDNUM
        }
        return 0
    }

    override fun getBookZipUrl(): String {
        return ""
    }

    override fun getBookType(): Int {
        return 0
    }

    override fun getLmId(): String {
        if (materialObj != null) {
            return materialObj!!.lmId
        }
        return ""
    }

    override fun getPicShowType(): Int {
        return if (materialObj != null) {
            if (!StringUtil.isEmpty(materialObj!!.CONTENT)) {
                LEVEL_TYPE
            } else {
                VERTICAL_TYPE
            }
        } else {
            LEVEL_TYPE
        }
    }

    override fun getContent(): String {
        return if (materialObj != null) materialObj!!.CONTENT else "暂无"
    }

    fun getBookId(): Int {
        if (materialObj != null) {
            return materialObj!!.KEYID
        }
        return 0
    }
}