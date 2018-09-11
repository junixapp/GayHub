package com.lxj.gayhub.base

import android.os.Bundle
import android.view.View
import com.blankj.utilcode.util.BarUtils
import com.lxj.gayhub.R
import me.imid.swipebacklayout.lib.app.SwipeBackActivity

abstract class BaseActivity: SwipeBackActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentView = View.inflate(this, getLayoutId(), null)
        setContentView(contentView)
        BarUtils.setStatusBarColor(this, resources.getColor(R.color.colorPrimary))
        BarUtils.addMarginTopEqualStatusBarHeight(contentView)
    }

    abstract fun getLayoutId(): Int

    override fun onBackPressed() {
        scrollToFinishActivity()
    }
}