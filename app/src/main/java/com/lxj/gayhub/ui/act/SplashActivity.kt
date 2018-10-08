package com.lxj.gayhub.ui.act

import android.os.Handler
import com.lxj.gayhub.R
import com.lxj.gayhub.base.BaseActivity
import com.lxj.gayhub.repository.sp.SpHelper
import kotlinx.android.synthetic.main.activity_container.*
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_splash

    override fun initView() {
        titlebar.hide()
        val string = getString(R.string.splash_small_txt)
        string.forEachIndexed { index, c ->
            tv_big.postDelayed({
                tv_small.text = "${tv_small.text}$c"
                tv_small2.alpha = (index+1).toFloat()/string.length

                if(index==(string.length-1)){
                    enterMain()
                }
            }, index* 20L)
        }

        tv_small2.setOnClickListener { startActivity<MainActivity>() }
    }

    private fun enterMain() {
        Handler().postDelayed({
            if (!SpHelper.isLogin()) {
                startActivity<LoginActivity>()
            } else {
                startActivity<MainActivity>()
            }
            finish()
        }, 600)
    }

}
