package com.lxj.gayhub.bean

import com.google.gson.Gson
import java.io.Serializable

open class BaseBean(
        var created_at: String = "",
        var updated_at: String = ""
) : Serializable {
    fun toJson() = Gson().toJson(this)
}