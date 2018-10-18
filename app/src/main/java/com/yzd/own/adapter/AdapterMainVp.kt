package com.yzd.own.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.ViewGroup
import java.util.ArrayList

/**
 * 作者: 杨智丹
 * 时间: 2018/10/17
 * 邮箱: zhidan_yang@163.com
 * 备注: 主页页面切换适配器
 */
class AdapterMainVp : FragmentStatePagerAdapter {

    var datas = ArrayList<Fragment>()

    constructor(fm: FragmentManager?, datas: ArrayList<Fragment>) : super(fm) {
        this.datas.addAll(datas)
    }

    override fun getItem(position: Int): Fragment {
        return datas.get(position)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        super.destroyItem(container, position, `object`)
    }

    override fun getCount(): Int {
        return datas.size
    }
}