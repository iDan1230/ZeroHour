package com.yzd.sdk

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

/**
 * 作者: 杨智丹
 * 时间: 2018/10/17
 * 邮箱: zhidan_yang@163.com
 * 备注:
 */
open class BaseApp : Application() {
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        //分包
        MultiDex.install(base)
    }

    override fun onCreate() {
        super.onCreate()

    }
}