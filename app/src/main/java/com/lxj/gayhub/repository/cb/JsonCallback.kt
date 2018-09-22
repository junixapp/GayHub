package com.lxj.gayhub.repository.cb

import com.google.gson.Gson
import com.lzy.okgo.callback.AbsCallback
import okhttp3.Response
import java.lang.reflect.ParameterizedType


abstract class JsonCallback<T>: AbsCallback<T>(){

    override fun convertResponse(response: Response): T? {
        val body = response.body() ?: return null

        val genType = javaClass.genericSuperclass
        val type = (genType as ParameterizedType).actualTypeArguments[0]
        return Gson().fromJson(body.charStream(), type)
    }
}