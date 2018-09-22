package com.lxj.gayhub.repository

import android.util.Base64
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import com.lxj.gayhub.base.BaseRepo
import com.lxj.gayhub.bean.AuthInfo
import com.lxj.gayhub.bean.UserInfo
import com.lxj.gayhub.repository.cb.JsonCallback
import com.lxj.gayhub.repository.config.Github
import com.lxj.gayhub.repository.sp.SpHelper
import com.lxj.gayhub.vm.enum.UIState
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okgo.request.base.Request
import org.jetbrains.anko.info
import org.json.JSONObject

object LoginRepo : BaseRepo() {
    lateinit var uiState: MutableLiveData<UIState>

    fun login(username: String, password: String, userInfoData:  MutableLiveData<UserInfo>) {
        // Basic authorization
        val userCredentials = username.trim() + ":" + password.trim()
        val basicAuth = "Basic " + String(Base64.encode(userCredentials.toByteArray(), Base64.DEFAULT))
        // auth headers
        val map = mapOf(
                "note" to Github.Note,
                "client_id" to Github.ClientId,
                "client_secret" to Github.ClientSecret
        )
        OkGo.post<AuthInfo>(Github.Authorization)
                .tag(this)
                .headers("Authorization", basicAuth.trim()) //trim防止换行
                .upJson(JSONObject(map)) // body params
                .execute(object : JsonCallback<AuthInfo>() {
                    override fun onStart(request: Request<AuthInfo, out Request<Any, Request<*, *>>>?) {
                        uiState.value = UIState.Loading
                    }
                    override fun onSuccess(response: Response<AuthInfo>) {
                        val authInfo = response.body()
                        //save token to sp
                        SpHelper.sp.edit { putString(SpHelper.KeyToken, authInfo.token) }

                        getUserInfo(username, userInfoData)
                    }

                })
    }

    fun getUserInfo(username: String, userInfoData:  MutableLiveData<UserInfo>){
        OkGo.get<UserInfo>(Github.UserInfo.format(username))
                .tag(this)
                .execute(object :JsonCallback<UserInfo>(){
                    override fun onError(response: Response<UserInfo>?) {
                        uiState.value = UIState.Error
                    }
                    override fun onSuccess(response: Response<UserInfo>) {
                        uiState.value = UIState.Success
                        //save user
                        SpHelper.sp.edit { putString(SpHelper.KeyUserInfo, response.body().toJson()) }

                        userInfoData.value = response.body()
                    }
                })
    }

}





