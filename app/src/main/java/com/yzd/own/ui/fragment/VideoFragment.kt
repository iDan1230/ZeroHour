package com.yzd.own.ui.fragment

import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import com.yzd.own.R
import com.yzd.own.adapter.AdapterHotVideo
import com.yzd.sdk.base.BaseFragment
import com.yzd.sdk.tools.CustomPageTransformer
import kotlinx.android.synthetic.main.fragment_video.view.*


/**
 * 作者: 杨智丹
 * 时间: 2018/10/18
 * 邮箱: zhidan_yang@163.com
 * 备注: 视频
 */
class VideoFragment : BaseFragment(), ViewPager.OnPageChangeListener {

    var listener: OnMenuListener? = null

    var hotVideo: AdapterHotVideo? = null
    override fun layoutId(): Int {
        return R.layout.fragment_video
    }

    override fun initTitle(rootView: View?) {
        rootView!!.toolbar.setNavigationOnClickListener {
            listener?.menuListener()
        }
    }

    override fun initView(rootView: View?) {

        var datas = ArrayList<String>()
        for (i in 0..10) {
            datas.add(i.toString() + "item")
        }
        hotVideo = AdapterHotVideo(context!!, datas)
        rootView!!.vpHotVideo.adapter = hotVideo
        rootView!!.vpHotVideo.addOnPageChangeListener(this)
        rootView!!.vpHotVideo.offscreenPageLimit = 7
        rootView!!.vpHotVideo.setPageTransformer(false, CustomPageTransformer())
    }

    override fun onPageSelected(position: Int) {
        Log.e("TAG", position.toString())
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }


    interface OnMenuListener {
        fun menuListener()
    }
}
