package com.yzd.own.ui.fragment

import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.yzd.own.R
import com.yzd.own.adapter.AdapterHotMovie
import com.yzd.own.adapter.AdapterMovie
import com.yzd.sdk.base.BaseFragment

import kotlinx.android.synthetic.main.fragment_movie.view.*


/**
 * 作者: 杨智丹
 * 时间: 2018/10/18
 * 邮箱: zhidan_yang@163.com
 * 备注: 视频
 */
class MovieFragment : BaseFragment(){

    var listener: OnMenuListener? = null

    var topMovie: AdapterMovie? = null

    override fun layoutId(): Int {
        return R.layout.fragment_movie
    }

    override fun initTitle(rootView: View?) {
        rootView!!.toolbar.setNavigationOnClickListener {
            listener!!.menuListener()
        }
    }

    override fun initView(rootView: View?) {

        var datas = ArrayList<String>()
        for (i in 0..10) {
            datas.add(i.toString() + "item")
        }
        topMovie = AdapterMovie(datas, context!!)
        rootView!!.recycler.layoutManager = LinearLayoutManager(context)
        rootView!!.recycler.adapter = topMovie
    }

    interface OnMenuListener {
        fun menuListener()
    }
}
