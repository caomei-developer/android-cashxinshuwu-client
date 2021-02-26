package com.xinshuwu.banner.helper

import android.content.Context
import android.content.Intent
import android.view.View
import com.xinshuwu.banner.bean.BannerA
import com.xinshuwu.banner.bean.BannerInfos
import com.xinshuwu.detail.BookDetailActivity
import com.xinshuwu.net.HttpUtil
import com.xinshuwu.net.Response
import com.xinshuwu.util.Utils
import com.xinshuwu.widget.AutoImageSwitcher
import com.xinshuwu.widget.compoment.pager.DotPageIndicator
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class BannersHelper {
    private var context: Context? = null
    private var location: Int = 0
    private var autoImageSwitcher: AutoImageSwitcher? = null
    private var dotPageIndicator: DotPageIndicator? = null
    private var banners: MutableList<BannerInfos>? = null
    private var bannersA: List<BannerA>? = null

    constructor(
        autoImageSwitcher: AutoImageSwitcher,
        dotPageIndicator: DotPageIndicator,
        location: Int,
        context: Context,
        callMode: Int
    ) {
        this.autoImageSwitcher = autoImageSwitcher
        this.dotPageIndicator = dotPageIndicator
        this.context = context
        this.location = location
        initCallback(callMode)
    }


    private fun initCallback(callMode: Int) {
        autoImageSwitcher!!.setCallback(object : AutoImageSwitcher.Callback {
            override fun onClick(position: Int) {
                if (callMode % 2 == 1) {
                    val map = HashMap<String, String>()
                    map["index"] = "" + position
                    var intent = Intent(context, BookDetailActivity().javaClass)
                    context!!.startActivity(intent)

                }
            }

            override fun onPageSelected(position: Int) {
                dotPageIndicator!!.setCurrent(position)
            }
        })
    }

    fun getBanner(callback: CallBack) {
        HttpUtil().apiConstant().banners()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Response<MutableList<BannerInfos>>> {
                override fun onSubscribe(@NonNull d: Disposable) {

                }

                override fun onNext(t: Response<MutableList<BannerInfos>>?) {
                    if (t != null && t!!.data != null && t!!.data != null) {
                        val bannerImgUrls = ArrayList<String>()
                        banners = t!!.data
                        for (i in 0 until t!!.data.size) {
                            bannerImgUrls.add(t!!.data[i].picture)
                        }
                        dotPageIndicator!!.setTotal(t!!.data.size)
                        autoImageSwitcher!!.visibility = View.VISIBLE
                        autoImageSwitcher!!.setImages(bannerImgUrls)
                        autoImageSwitcher!!.setPaused(false)
                    } else {
                        Utils.showToast(t!!.msg)
                    }
                }

                override fun onError(@NonNull e: Throwable) {
                    Utils.showToast(e.message)

                }

                override fun onComplete() {

                }
            })


    }

    fun getBannerA(callback: CallBack) {
        HttpUtil().apiFzAConstant().bannerA()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Response<List<BannerA>>> {
                override fun onSubscribe(@NonNull d: Disposable) {

                }

                override fun onNext(t: Response<List<BannerA>>?) {
                    if (t != null && t!!.data != null && t!!.data != null) {
                        val bannerImgUrls = ArrayList<String>()
                        bannersA = t!!.data
                        for (element in t.data) {
                            bannerImgUrls.add(element.pictureUrl)
                        }
                        dotPageIndicator!!.setTotal(t!!.data.size)
                        autoImageSwitcher!!.visibility = View.VISIBLE
                        autoImageSwitcher!!.setImages(bannerImgUrls)
                        autoImageSwitcher!!.setPaused(false)
                    } else {
                        Utils.showToast(t!!.msg)
                    }
                }

                override fun onError(@NonNull e: Throwable) {
                    Utils.showToast(e.message)

                }

                override fun onComplete() {

                }
            })
    }

    interface CallBack {
        fun onSuccess()

        fun onError()
    }

}