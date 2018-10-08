package com.lxj.qingframework.exts.logger

import com.google.gson.Gson
import com.orhanobut.logger.Logger

/**
 * String exts for logger.
 */
// logger for string
fun String.d() = Logger.d(this)
fun String.e() = Logger.e(this)
fun String.w() = Logger.w(this)
fun String.v() = Logger.v(this)
fun String.i() = Logger.i(this)
fun String.jsonLog() = Logger.json(this)
fun String.xmlLog() = Logger.xml(this)

// logger for Any
fun Any.d() = this.toString().d()
fun Any.e() = this.toString().e()
fun Any.w() = this.toString().w()
fun Any.v() = this.toString().v()
fun Any.i() = this.toString().i()
fun Any.jsonLog() = Gson().toJson(this).jsonLog()
fun Any.xmlLog() = Gson().toJson(this).xmlLog()
