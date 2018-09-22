package com.lxj.gayhub.ui.act

import android.app.ProgressDialog
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lxj.gayhub.R
import com.lxj.gayhub.base.BaseActivity
import com.lxj.gayhub.bean.AuthInfo
import com.lxj.gayhub.bean.UserInfo
import com.lxj.gayhub.vm.LoginVM
import com.lxj.gayhub.vm.enum.UIState
import kotlinx.android.synthetic.main.activity_container.*
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity() {
    lateinit var loginVM: LoginVM

    override fun getLayoutId(): Int = R.layout.activity_login

    lateinit var progressDialog: ProgressDialog
    override fun initView() {
        titlebar.title(getString(R.string.login))
        btn_login.setOnClickListener(this)
        progressDialog = ProgressDialog(this)
        progressDialog.isIndeterminate = true
        progressDialog.setMessage("Logining")
    }

    override fun bindViewModel() {
        loginVM = ViewModelProviders.of(this).get(LoginVM::class.java)
        loginVM.uiState.observe(this, Observer<UIState> {
            when(it){
                UIState.Loading -> {
                    progressDialog.show()
                }
                else -> progressDialog.hide()
            }
        })

        loginVM.userInfoData.observe(this, Observer<UserInfo> {
            if(it!=null){
                startActivity<MainActivity>()
                finish()
            }
        })
    }

    override fun onClick(v: View) {
        if(checkInput()){
            loginVM.login(et_username.text.toString(), et_password.text.toString())
        }
    }

    private fun checkInput(): Boolean{
        if(et_username.text.toString().isEmpty()){
            et_username.requestFocus()
            return false
        }
        if(et_password.text.toString().isEmpty()){
            et_password.requestFocus()
            return false
        }
        return true
    }
}