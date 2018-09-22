package com.lxj.gayhub.bean

import java.io.Serializable

/**
 * {
    "name": "GayHub",
    "url": "https://github.com/li-xiaojun/GayHub",
    "client_id": "c3a21fc5675667cc6080"
    }
 */
data class AppInfo(
     var name: String,
     var url: String,
     var client_id: String
): Serializable