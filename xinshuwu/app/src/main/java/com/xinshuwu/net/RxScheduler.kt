package com.xinshuwu.net

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.core.ObservableTransformer
import io.reactivex.rxjava3.schedulers.Schedulers

class RxScheduler {
    fun <T> observableTransformer(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream!!.flatMap { t ->
                val response = t as Response<T>
                if (response.code > 0) {
                    createData(t)
                } else {
                    Observable.error<T>(Exception(response.msg))
                }
            }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()) as ObservableSource<T>
        }
    }


    private fun <T> createData(data: T): Observable<T> {
        return Observable.create { subscriber ->
            try {
                subscriber.onNext(data)
                subscriber.onComplete()
            } catch (e: Exception) {
                subscriber.onError(e)
            }
        }
    }
}