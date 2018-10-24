package com.yzd.sdk.tools

import android.annotation.SuppressLint
import android.support.v4.view.ViewPager
import android.view.View

/**
 * 作者: 杨智丹
 * 时间: 2018/10/18
 * 邮箱: zhidan_yang@163.com
 * 备注: ViewPager样式
 */
class CustomPageTransformer : ViewPager.PageTransformer {
    val MIN_SCALE_X = 0.95f
    val MIN_SCALE_Y = 0.95f
    val MIN_ALPHA = 0.95f
    var pageWidth: Int = 0
    var translationZ = 10f
    var stand_out_space = 0.3f

    @SuppressLint("NewApi")
    override fun transformPage(page: View, position: Float) {
        if (position == 0f) {
            pageWidth = page.width
            page.scaleX = 1f
            page.scaleY = 1f
            page.alpha = 1f
            page.translationX = 0f
            page.translationZ = translationZ
        } else {
            val scaleFactorX = MIN_SCALE_X + (1 - MIN_SCALE_X) * (1 - Math.abs(position))
            val scaleFactorY = MIN_SCALE_Y + (1 - MIN_SCALE_Y) * (1 - Math.abs(position))
            val alphaFactor = MIN_ALPHA + (1 - MIN_ALPHA) * (1 - Math.abs(position))
            page.scaleX = scaleFactorX
            page.scaleY = scaleFactorY
            page.alpha = MIN_ALPHA
            // 为了体现出层次感，卡片式特色
            page.translationZ = translationZ - Math.abs(position)
            if (position > 0) {
                //移动到和显示也重叠的位置加上Stan out
                page.translationX = -1 * Math.abs(pageWidth * position) + position * pageWidth * stand_out_space
            }
            if (position <= 0) {
                //posision为负值
                page.translationX = Math.abs(pageWidth * position) + position * pageWidth * stand_out_space
            }
        }

    }
}