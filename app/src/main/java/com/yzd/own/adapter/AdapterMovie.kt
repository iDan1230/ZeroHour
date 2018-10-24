package com.yzd.own.adapter

import android.content.Context
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yzd.own.R
import com.yzd.sdk.tools.CustomPageTransformer
import kotlinx.android.synthetic.main.fragment_movie.view.*
import org.jetbrains.anko.onClick

/**
 * 作者: 杨智丹
 * 时间: 2018/10/19
 * 邮箱: zhidan_yang@163.com
 * 备注: 排名靠前的影片
 */
class AdapterMovie(var datas: ArrayList<String>, var mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) 0 else 1

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            HotHolder(LayoutInflater.from(mContext).inflate(R.layout.item_hot_movie, parent, false))
        } else {
            TopHolder(LayoutInflater.from(mContext).inflate(R.layout.item_top_movie, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.e("top", position.toString())
        when (getItemViewType(position)) {
            0 -> onHotBind(holder as HotHolder, position)
            1 -> onTopBind(holder as TopHolder, position)
            else -> {
                Log.e("else", position.toString())
            }
        }
    }

    private fun onTopBind(topHolder: TopHolder, position: Int) {
        topHolder.itemView.onClick {
            Log.e("else", position.toString())
        }
    }

    var hotMovie: AdapterHotMovie? = null
    var currentItemPosition = 0
    private fun onHotBind(hotHolder: HotHolder, position: Int) {
        var datas = ArrayList<String>()
        for (i in 0..10) {
            datas.add(i.toString() + "item$position")
        }
        if (null == hotMovie) {
            hotMovie = AdapterHotMovie(mContext, datas)
            hotHolder.vpHotVideo.adapter = hotMovie
            hotHolder.vpHotVideo.offscreenPageLimit = 5
            hotHolder.vpHotVideo.setPageTransformer(false, CustomPageTransformer())
        }
//        hotHolder!!.vpHotVideo.currentItem = currentItemPosition


        hotHolder.vpHotVideo.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                currentItemPosition = position;
            }

        })
    }


    inner class HotHolder(view: View) : RecyclerView.ViewHolder(view) {
        val vpHotVideo = view.findViewById<ViewPager>(R.id.vp_hot_movie)
    }


    inner class TopHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}