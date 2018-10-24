package com.yzd.own.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.yzd.own.R
import org.jetbrains.anko.onClick

/**
 * 作者: 杨智丹
 * 时间: 2018/10/18
 * 邮箱: zhidan_yang@163.com
 * 备注: 热映视频的适配器
 */
class AdapterHotMovie : PagerAdapter {

    private var mContext: Context? = null

    private var datas = ArrayList<String>()

    private var views = ArrayList<View>()


    constructor(context: Context, datas: ArrayList<String>) {
        this.mContext = context
        this.datas.addAll(datas)
//        this.datas.forEach {
//            views.add(LayoutInflater.from(mContext).inflate(R.layout.item_vp_movie, null))
//        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        super.destroyItem(container, position, `object`)
//        container.removeViewAt(position)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        if (position >= views.size) {
            var view = LayoutInflater.from(mContext).inflate(R.layout.item_vp_movie,null)
            var tvContent = view.findViewById<TextView>(R.id.tv_content)
            tvContent.text ="推荐${position.toString()}"
            view.onClick {
                Log.e("vp",position.toString())
            }
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