package com.lxj.gayhub.ui.act

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lxj.gayhub.R
import com.lxj.gayhub.base.BaseActivity
import com.lxj.gayhub.bean.UserInfo
import com.lxj.gayhub.vm.LoginVM
import com.lxj.gayhub.vm.enum.UIState
import com.lxj.qingframework.inputmethod.hideInputMethod
import com.lxj.statelayout.StateLayout
import com.lxj.statelayout.setLoadingRes
import kotlinx.android.synthetic.main.activity_container.*
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : BaseActivity() {
    lateinit var loginVM: LoginVM
    lateinit var loginStateLayout: StateLayout

    override fun getLayoutId(): Int = R.layout.activity_login

    override fun initView() {
        titlebar.title(getString(R.string.login))
        btn_login.setOnClickListener(this)

        // Statela
        loginStateLayout = StateLayout(this)
                .setLoadingRes(R.layout.layout_login_loading)
                .wrap(btn_login)
        loginStateLayout.showContent()

    }

    override fun bindViewModel() {
        loginVM = ViewModelProviders.of(this).get(LoginVM::class.java)
        loginVM.uiState.observe(this, Observer<UIState> {
            when (it) {
                UIState.Loading -> loginStateLayout.showLoading()
                else -> loginStateLayout.showContent()
            }
        })

        loginVM.userInfoData.observe(this, Observer<UserInfo> {
            if (it != null) {
                startActivity<MainActivity>()
                finish()
            }
        })
    }

    override fun onClick(v: View) {
        if (checkInput()) {
            v.apply {
                isFocusable = true
                isFocusableInTouchMode = true
                requestFocus()
            }
            loginVM.login(et_username.text.toString(), et_password.text.toString())
            hideInputMethod()
        }
    }

    private fun checkInput(): Boolean {
        if (et_username.text.toString().isEmpty()) {
            et_username.requestFocus()
            return false
        }
        if (et_password.text.toString().isEmpty()) {
            et_password.requestFocus()
            return false
        }
        return true
    }
}