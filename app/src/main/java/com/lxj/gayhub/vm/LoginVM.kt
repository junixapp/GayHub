package com.lxj.gayhub.vm

import androidx.lifecycle.MutableLiveData
import com.lxj.gayhub.base.BaseVM
import com.lxj.gayhub.bean.UserInfo
import com.lxj.gayhub.repository.LoginRepo
import com.lxj.gayhub.vm.enum.UIState

class LoginVM : BaseVM() {

    val userInfoData =  MutableLiveData<UserInfo>()
    val loginState = MutableLiveData<UIState>()
    val loginRepo = LoginRepo(this)
    init {
    }

    fun login(username: String, password: String) {
        loginRepo.login(username, password)
    }

    override fun onCleared() {
        super.onCleared()
        loginRepo.onCleared()
    }
}