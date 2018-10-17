package com.yzd.sdk.utils

import android.content.Context

/**
 * 作者: 杨智丹
 * 时间: 2018/10/17
 * 邮箱: zhidan_yang@163.com
 * 备注:
 */
class DisplayUtil {

    companion object {
        fun dip2px(context: Context, dipValue: Float): Int {
            val scale = context.resources.displayMetrics.density
            return (dipValue * scale + 0.5f).toInt()
        }
    }
}