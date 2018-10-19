package com.yzd.own.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.yzd.own.R
import com.yzd.own.adapter.AdapterMovie
import com.yzd.own.adapter.AdapterNBA
import com.yzd.sdk.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_movie.view.*


/**
 * 作者: 杨智丹
 * 时间: 2018/10/18
 * 邮箱: zhidan_yang@163.com
 * 备注:
 */
class NBAFragment : BaseFragment() {
    var eventNBA: AdapterNBA? = null
    override fun layoutId(): Int {
        return R.layout.fragment_nba
    }

    override fun initTitle(rootView: View?) {

    }

    override fun initView(rootView: View?) {

        var datas = ArrayList<String>()
        for (i in 0..10) {
            datas.add(i.toString() + "item")
        }
        eventNBA = AdapterNBA(context!!, datas)
        rootView!!.recycler.layoutManager = LinearLayoutManager(context)
        rootView!!.recycler.adapter = eventNBA
    }


}
