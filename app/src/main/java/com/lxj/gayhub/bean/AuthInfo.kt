package com.lxj.gayhub.bean

import java.io.Serializable

/**
 * {
    "id": 219617460,
    "url": "https://api.github.com/authorizations/219617460",
    "app": {
        "name": "GayHub",
        "url": "https://github.com/li-xiaojun/GayHub",
        "client_id": "c3a21fc5675667cc6080"
    },
    "token": "1f9ae747e6643d024e739a2c2e9d65df5dbe5776",
    "hashed_token": "7c8195772f96db1601ec0690d0d8ca5194ec06affba3e710d2dbe5f5c60408fd",
    "token_last_eight": "5dbe5776",
    "note": "GayHub",
    "note_url": null,
    "created_at": "2018-09-15T09:32:29Z",
    "updated_at": "2018-09-15T09:32:29Z",
    "scopes": [],
    "fingerprint": null
}
 */
data class AuthInfo(
        var id: String,
        var url: String,
        var app: AppInfo,
        var token: String,
        var hashed_token: String,
        var token_last_eight: String,
        var note: String,
        var note_url: String,
        var scopes: Array<String>,
        var fingerprint: String
):BaseBean()