package com.yzd.own.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.yzd.own.R

/**
 * 作者: 杨智丹
 * 时间: 2018/10/18
 * 邮箱: zhidan_yang@163.com
 * 备注: 热映视频的适配器
 */
class AdapterHotVideo : PagerAdapter {

    private var mContext: Context? = null

    private var datas = ArrayList<String>()

    private var views = ArrayList<View>()

    constructor(context: Context, datas: ArrayList<String>) {
        this.mContext = context
        this.datas.addAll(datas)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        super.destroyItem(container, position, `object`)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        if (position >= views.size)
        {
            var view = LayoutInflater.from(mContext).inflate(R.layout.item_hot_video,null)
            views.add(view)
            container.addView(view)
        }
        return views.get(position)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return datas.size
    }
}