package com.lxj.gayhub.bean

/**
 * login : TellH
 * id : 15800681
 * avatar_url : https://avatars.githubusercontent.com/u/15800681?v=3
 * gravatar_id :
 * url : https://api.github.com/users/TellH
 * html_url : https://github.com/TellH
 * followers_url : https://api.github.com/users/TellH/followers
 * following_url : https://api.github.com/users/TellH/following{/other_user}
 * gists_url : https://api.github.com/users/TellH/gists{/gist_id}
 * starred_url : https://api.github.com/users/TellH/starred{/owner}{/repo}
 * subscriptions_url : https://api.github.com/users/TellH/subscriptions
 * organizations_url : https://api.github.com/users/TellH/orgs
 * repos_url : https://api.github.com/users/TellH/repos
 * events_url : https://api.github.com/users/TellH/events{/privacy}
 * received_events_url : https://api.github.com/users/TellH/received_events
 * type : User
 * site_admin : false
 * name : 乐华
 * company : studying in college
 * blog : http://blog.csdn.net/tellh?viewmode=contents
 * location : GuangDong
 * email : 570495627@qq.com
 * hireable : null
 * bio : Stay hungry, stay foolish.
 * public_repos : 35
 * public_gists : 0
 * followers : 13
 * following : 37
 * created_at : 2015-11-11T13:28:55Z
 * updated_at : 2016-08-22T12:16:31Z
 */
data class UserInfo(
    var login: String,
    var id: Int,
    var node_id: String,
    var avatar_url: String,
    var gravatar_id: String,
    var url: String,
    var html_url: String,
    var followers_url: String,
    var following_url: String,
    var gists_url: String,
    var starred_url: String,
    var subscriptions_url: String,
    var organizations_url: String,
    var repos_url: String,
    var events_url: String,
    var received_events_url: String,
    var type: String,
    var site_admin: Boolean,
    var name: String,
    var company: String,
    var blog: String,
    var location: String,
    var email: String,
    var hireable: String,
    var bio: String,
    var public_repos: Int,
    var public_gists: Int,
    var followers: Int,
    var following: Int
):BaseBean()