package com.xinshuwu.banner.bean

data class BannerInfos(
    val addtime: Int,
    val addtime_text: String,
    val gender: Int,
    val id: Int,
    val name: String,
    val path: String,
    val picture: String,
    val status: Int,
    val type: Int,
    val updatetime: Int
)

data class BannerA(
    val appId: Int,
    val createBy: String,
    val createdAt: String,
    val createdTime: String,
    val dataScope: String,
    val gender: Int,
    val id: Int,
    val jumpUrl: String,
    val name: String,
    val params: String,
    val pictureUrl: String,
    val state: Int,
    val updateBy: String,
    val updatedAt: String,
    val updatedTime: String
)

