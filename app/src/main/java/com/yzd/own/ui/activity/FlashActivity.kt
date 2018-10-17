package com.yzd.own.ui.activity

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.yzd.own.R
import com.yzd.sdk.base.BaseActivity
import kotlinx.android.synthetic.main.activity_flash.*
import org.jetbrains.anko.startActivity

/**
 * 作者: 杨智丹
 * 时间: 2018/10/17
 * 邮箱: zhidan_yang@163.com
 * 备注: 启动页
 */
class FlashActivity : BaseActivity() {
    override fun layoutId(): Int {
        return R.layout.activity_flash;
    }

    override fun initTitle() {
    }

    override fun initView(savedInstanceState: Bundle?) {
        ivRunning.setImageResource(R.drawable.anim_running)
        val anima = ivRunning.drawable as AnimationDrawable;
        val translate = AnimationUtils.loadAnimation(this, R.anim.anim_right_to_left)
        anima.start()
        ivRunning.startAnimation(translate)
        ivRunning.postDelayed(Runnable {
            startActivity<MainActivity>()
            finish()
        }, 3000)
    }

    override fun initData() {
    }


}
