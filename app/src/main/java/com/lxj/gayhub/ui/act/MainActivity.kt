package com.lxj.gayhub.ui.act

import androidx.viewpager.widget.ViewPager
import com.google.android.material.animation.ArgbEvaluatorCompat
import com.lxj.gayhub.R
import com.lxj.gayhub.base.BaseActivity
import com.lxj.gayhub.ui.adapter.MainAdapter
import com.lxj.qingframework.exts.logger.d
import kotlinx.android.synthetic.main.activity_container.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(){
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        titlebar.hide()
        viewPager.adapter = MainAdapter(supportFragmentManager)

        val evaluator = ArgbEvaluatorCompat()
        val checkedColor = resources.getColor(R.color.main_tab_checked)
        val uncheckedColor = resources.getColor(R.color.main_tab_unchecked)
        viewPager.addOnPageChangeListener(object :ViewPager.SimpleOnPageChangeListener(){
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                when (position) {
                    0 -> {
                        rb_see.setTextColor(evaluator.evaluate(positionOffset, checkedColor, uncheckedColor))
                        rb_search.setTextColor(evaluator.evaluate(positionOffset, uncheckedColor, checkedColor))
                    }
                    1 -> {
                        rb_search.setTextColor(evaluator.evaluate(positionOffset, checkedColor, uncheckedColor))
                        rb_me.setTextColor(evaluator.evaluate(positionOffset, uncheckedColor, checkedColor))
                    }
                }
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> radioGroup.check(R.id.rb_see)
                    1 -> radioGroup.check(R.id.rb_search)
                    2 -> radioGroup.check(R.id.rb_me)
                }
            }
        })

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.rb_see -> viewPager.currentItem = 0
                R.id.rb_search -> viewPager.currentItem = 1
                R.id.rb_me -> viewPager.currentItem = 2
            }
        }
    }
}

