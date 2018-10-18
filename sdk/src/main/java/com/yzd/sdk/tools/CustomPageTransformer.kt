package com.yzd.sdk.tools

import android.annotation.SuppressLint
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View

/**
 * 作者: 杨智丹
 * 时间: 2018/10/18
 * 邮箱: zhidan_yang@163.com
 * 备注: ViewPager样式
 */
class CustomPageTransformer : ViewPager.PageTransformer {
    val MIN_SCALE_X = 0.8f
    val MIN_SCALE_Y = 0.8f
    val MIN_ALPHA = 0.8f
    var pageWidth: Int = 0

    @SuppressLint("NewApi")
    override fun transformPage(page: View, position: Float) {
        Log.e("page", position.toString())

        if (position == 0f) {
            pageWidth = page.width
            page.scaleX = 1f
            page.scaleY = 1f
            page.alpha = 1f
            page.translationZ = 3f
            page.elevation = 3f
            page.setTranslationX(0f)
        } else {
            val scaleFactorX = MIN_SCALE_X + (1 - MIN_SCALE_X) * (1 - Math.abs(position))
            val scaleFactorY = MIN_SCALE_Y + (1 - MIN_SCALE_Y) * (1 - Math.abs(position))
            val alphaFactor = MIN_ALPHA + (1 - MIN_ALPHA) * (1 - Math.abs(position))
            page.setScaleX(scaleFactorX)
            page.setScaleY(scaleFactorY)
            page.setAlpha(alphaFactor)

            if (position >0) {
                page.setTranslationX((-1 * Math.abs(pageWidth * position) / 2).toFloat())
            }
            if (position <= 0) {
                page.setTranslationX((Math.abs(pageWidth * position) / 2).toFloat())
            }
        }

    }
}