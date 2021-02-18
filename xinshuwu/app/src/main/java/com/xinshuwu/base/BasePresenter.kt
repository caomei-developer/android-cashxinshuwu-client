package com.xinshuwu.base

open class BasePresenter<V : BaseView> {
    protected var mView: V? = null

    //绑定
    fun attachView(view: V) {
        this.mView = view
    }

    //解除
    fun detachView() {
        this.mView = null
    }

    //是否绑定
    fun isViewAttached(): Boolean {
        return mView != null
    }
}