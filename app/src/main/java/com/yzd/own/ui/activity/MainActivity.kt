package com.yzd.own.ui.activity

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.view.MenuItem
import android.view.animation.LinearInterpolator
import com.yzd.own.R
import com.yzd.own.adapter.AdapterMainVp
import com.yzd.own.ui.fragment.*
import com.yzd.sdk.base.BaseActivity
import com.yzd.sdk.utils.DisplayUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_main_side.*
import java.lang.reflect.Field
import java.util.ArrayList

/**
 * 作者: 杨智丹
 * 时间: 2018/10/17
 * 邮箱: zhidan_yang@163.com
 * 备注: 主页面
 */
class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener, MovieFragment.OnMenuListener {

    var menuItem: MenuItem? = null

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initTitle() {

    }

    override fun initView(savedInstanceState: Bundle?) {
        addAnim()
        navBottom.setOnNavigationItemSelectedListener(this)
        disableShiftMode()
    }

    override fun initData() {
        setVpData()
    }

    /*
       ViewPager 设置数据绑定适配器
     */
    private fun setVpData() {
        var datas = ArrayList<Fragment>()
        var videoFragment = MovieFragment()
        videoFragment.listener = this
        datas.add(videoFragment)
        datas.add(NBAFragment())
        datas.add(MusicFragment())
        datas.add(BooksFragment())
        vpContent.adapter = AdapterMainVp(supportFragmentManager, datas)
        vpContent.addOnPageChangeListener(this)
    }

    /*
      给抽屉背景添加一个左右滑动的动画效果
     */
    private fun addAnim() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            val animator = ObjectAnimator.ofFloat(ivSideBg, "translationX", 0.0f, DisplayUtil.dip2px(this, 500f) * -1 + DisplayUtil.dip2px(this, 300f).toFloat(), 0.0f)
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
            R.id.nav_movie -> {
                vpContent.currentItem = 0
            }
            R.id.nav_nba -> {
                vpContent.currentItem = 1
            }
            R.id.nav_music -> {
                vpContent.currentItem = 2
            }
            R.id.nav_books -> {
                vpContent.currentItem = 3
            }
        }
        return true
    }


    override fun onPageSelected(position: Int) {
        if (menuItem != null) {
            menuItem!!.setChecked(false);
        } else {
            navBottom.menu.getItem(0).setChecked(false);
        }
        menuItem = navBottom.menu.getItem(position);
        menuItem!!.setChecked(true);
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun menuListener() {
        drawerLayout.openDrawer(GravityCompat.START)
    }


    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else
            super.onBackPressed()
    }


    @SuppressLint("RestrictedApi")
    fun disableShiftMode() {
        var menuView = navBottom.getChildAt(0) as BottomNavigationMenuView

        var shiftingMode: Field = menuView.javaClass.getDeclaredField("mShiftingMode")

        shiftingMode.isAccessible = true

        shiftingMode.setBoolean(menuView, false)

        shiftingMode.isAccessible = false
        //闭区间
        for (i in 0..menuView.childCount) {
            var item = menuView.getChildAt(i) as? BottomNavigationItemView
            item?.setShiftingMode(false)
            item?.setChecked(item.itemData.isChecked)
        }

    }

}