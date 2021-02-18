package com.xinshuwu.recomend.bean


data class Recommends(
    val LMLIST: List<LMLIST>
)

data class LMLIST(
    val BOOKS: List<BOOKS>,
    val LMID: String,
    val LMNAME: String,
    val LMTYPE: String
)

data class BOOKS(
    val AUTHORID: Int,
    val AUTHORNAME: String,
    val CONTENT: String,
    val COVERURL: String,
    val KEYID: Int,
    val KEYNAME: String,
    val KEYTYPE: String,
    val SUBJECT: Int,
    val WORDNUM: Int
)
