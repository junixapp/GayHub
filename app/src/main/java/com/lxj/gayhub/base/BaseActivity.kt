package com.lxj.gayhub.base

import android.os.Bundle
import android.view.View
import com.blankj.utilcode.util.BarUtils
import com.lxj.gayhub.R
import com.lxj.gayhub.ui.widget.TitleBar
import kotlinx.android.synthetic.main.activity_container.*
import me.imid.swipebacklayout.lib.app.SwipeBackActivity
import org.jetbrains.anko.AnkoLogger

abstract class BaseActivity : SwipeBackActivity(), TitleBar.OnActionClickListener, AnkoLogger, View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
        // 1. set titlebar listener
        titlebar.actionClickListener = this

        // 2. add content view
        container.addView(View.inflate(this, getLayoutId(), null))

        // 3. set statusbar, set margin of container
        BarUtils.setStatusBarColor(this, resources.getColor(R.color.colorPrimary), 75)
        BarUtils.addMarginTopEqualStatusBarHeight(container.parent as View)

        //4. bind vms
        bindViewModel()
        //5. call initView
        initView()
        //6. load data
        loadData()
    }

    abstract fun getLayoutId(): Int
    open fun bindViewModel() {}
    open fun initView() {}
    open fun loadData() {}

    override fun onClick(v: View) {
    }

//    override fun finish() {
//        super.finish()
//        //注释掉activity本身的过渡动画
//        overridePendingTransition(R.anim.activity_close_enter, R.anim.activity_close_exit)
//    }

}