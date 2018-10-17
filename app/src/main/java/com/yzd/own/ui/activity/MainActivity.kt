package com.yzd.own.ui.activity

import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.animation.LinearInterpolator
import com.yzd.own.R
import com.yzd.own.adapter.AdapterMainVp
import com.yzd.sdk.base.BaseActivity
import com.yzd.sdk.utils.DisplayUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_main_side.*
import java.util.ArrayList

/**
 * 作者: 杨智丹
 * 时间: 2018/10/17
 * 邮箱: zhidan_yang@163.com
 * 备注: 主页面
 */
class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initTitle() {
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun initView(savedInstanceState: Bundle?) {
        addAnim()
        navBottom.setOnNavigationItemSelectedListener(this)

    }

    override fun initData() {
        setVpData()
    }
    /*
       ViewPager 设置数据绑定适配器
     */
    private fun setVpData() {
        var datas = ArrayList<Fragment>()
        while (datas.size < 3){
//            datas.add(ItemFragment())
        }
//        vpContent.adapter = AdapterMainVp(datas)
    }
    /*
      给抽屉背景添加一个左右滑动的动画效果
     */
    private fun addAnim() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            val animator = ObjectAnimator.ofFloat(ivSideBg, "translationX", 0.0f, DisplayUtil.dip2px(this, 600f) * -1 + DisplayUtil.dip2px(this, 300f).toFloat(), 0.0f)
            animator.duration = 25000//动画时间
            animator.interpolator = LinearInterpolator()//实现反复移动的效果
            animator.repeatCount = -1//设置动画重复次数
            animator.startDelay = 1000//设置动画延时执行
            animator.start()//启动动画
        }
    }
    /*
       BottomNav选中事件触发
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_video -> supportActionBar!!.title = "video"
            R.id.nav_music -> supportActionBar!!.title = "music"
            R.id.nav_books -> supportActionBar!!.title = "books"
        }
        return true
    }

}