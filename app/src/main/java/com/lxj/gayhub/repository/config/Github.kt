package com.lxj.gayhub.repository.config

class Github{
    companion object {
        const val Note = "Gayhub"
        const val ClientId = "c3a21fc5675667cc6080"
        const val ClientSecret = "809c7ac497a289470503a44151d0bdffa7a7c0ea"

        const val BaseUrl = "https://api.github.com/"
        const val Authorization = "${BaseUrl}authorizations"
        const val UserInfo = "${BaseUrl}users/%s"
    }
}