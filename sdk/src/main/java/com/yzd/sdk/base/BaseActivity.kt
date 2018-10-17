package com.yzd.sdk.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 作者: 杨智丹
 * 时间: 2018/10/17
 * 邮箱: zhidan_yang@163.com
 * 备注: 活动基类
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initView(savedInstanceState)
        initTitle()
        initData()

    }

    abstract fun layoutId(): Int

    abstract fun initTitle()

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initData()
}
