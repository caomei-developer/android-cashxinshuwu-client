package com.xinshuwu.detail.bean


data class BookDetail(
    val AID: Int,
    val ANAME: String,
    val BID: Int,
    val BNAME: String,
    val BTAG: List<BTAG>,
    val BTID: Int,
    val BTITLE: String,
    val BTNAME: String,
    val CNUM: Int,
    val CONTENT: String,
    val COVERURL: String,
    val FIRSTCCONTENT: String,
    val INTUPTIME: String,
    val ISGROUON: Int,
    val ISUNLOCK: Int,
    val NCID: Int,
    val NEWCHAPTER: String,
    val RANK: Int,
    val SECONDCID: Int,
    val STATE: Int,
    val WORDNUM: Int
)

data class BTAG(
    val TAGID: Int,
    val TAGNAME: String
)
