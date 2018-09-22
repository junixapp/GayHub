package com.lxj.gayhub.repository.sp

import android.content.Context
import android.content.SharedPreferences
import com.lxj.gayhub.GayHubApp

object SpHelper {
    val KeyToken = "KeyToken"
    val KeyUserInfo = "KeyUserInfo"

    var sp: SharedPreferences = GayHubApp.context.getSharedPreferences("Gayhub", Context.MODE_PRIVATE)

    fun isLogin() = sp.getString(KeyToken,"").isNotEmpty() && sp.getString(KeyUserInfo,"").isNotEmpty()
}