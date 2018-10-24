package com.yzd.sdk.tools

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by yangzhidan on 2018/10/23.
 */
object RxHelper {

    /**
     * 统一线程管理
     * io线程发布事件，主线程接受
     * @param <T>
     * @return
    </T> */
    fun <T> rxScheduleHelper(): ObservableTransformer<T, T> {

        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }
}