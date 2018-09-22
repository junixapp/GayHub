package com.lxj.gayhub.vm

import androidx.lifecycle.MutableLiveData
import com.lxj.gayhub.base.BaseVM
import com.lxj.gayhub.bean.AuthInfo
import com.lxj.gayhub.bean.UserInfo
import com.lxj.gayhub.repository.LoginRepo

class LoginVM : BaseVM() {

    val userInfoData =  MutableLiveData<UserInfo>()

    init {
        LoginRepo.uiState = uiState
    }

    fun login(username: String, password: String) {
        LoginRepo.login(username, password, userInfoData)
    }

    override fun onCleared() {
        super.onCleared()
        LoginRepo.onCleared()
    }
}