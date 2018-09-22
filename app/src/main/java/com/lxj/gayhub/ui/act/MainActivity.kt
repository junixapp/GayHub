package com.lxj.gayhub.ui.act

import android.os.Bundle
import com.lxj.gayhub.R
import com.lxj.gayhub.base.BaseActivity
import kotlinx.android.synthetic.main.activity_container.*
import org.jetbrains.anko.info
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : BaseActivity(){
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        titlebar.addActionButton(actionBtn1 = getString(R.string.ic_add),
                actionBtn2 = getString(R.string.ic_close),
                actionBtn3 = getString(R.string.ic_more))

    }

    override fun onAction3Click() {
        toast("click")
    }

    override fun onAction1Click() {
        super.onAction1Click()
        toast("add")
    }
}

