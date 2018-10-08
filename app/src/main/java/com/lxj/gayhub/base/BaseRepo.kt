package com.lxj.gayhub.base

import com.lzy.okgo.OkGo

/**
 * Data Access Layer.
 * You can put your DB, Http, File, SharedPref codes here.
 * When get data, set it to LiveData.
 */
open class BaseRepo {
    open fun onCleared() {
        OkGo.getInstance().cancelTag(this)

    }
}