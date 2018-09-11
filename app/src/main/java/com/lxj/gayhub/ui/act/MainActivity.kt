package com.lxj.gayhub.ui.act

import com.lxj.gayhub.R
import com.lxj.gayhub.base.BaseActivity
import kotlinx.android.synthetic.main.activity_container.*
import org.jetbrains.anko.toast

class MainActivity : BaseActivity(){
    override fun getLayoutId(): Int = R.layout.activity_main

    init {
//        ActivityUtils.startActivity(SplashActivity::class.java)
        titlebar.addActionButton(actionBtn1 = )
    }

    override fun onAction3Click() {
        toast("click")
    }

    override fun onAction1Click() {
        super.onAction1Click()
        titlebar.actionClickListener = null
    }
}

