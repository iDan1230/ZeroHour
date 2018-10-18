package com.yzd.sdk.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by yangzhidan on 2018/10/18.
 */
abstract class BaseFragment : Fragment() {

    var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        if (null == rootView) {
            rootView = inflater.inflate(layoutId(), null)
            initView(rootView)
            initTitle(rootView)
        }
        val parent = rootView?.parent
        (parent as? ViewGroup)?.removeView(rootView)
        return rootView
    }

    abstract fun layoutId(): Int

    abstract fun initTitle(rootView: View?)

    abstract fun initView(rootView: View?)

}