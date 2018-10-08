package com.lxj.qingframework.inputmethod

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/*
 * exts for InputMethodManager
 */

fun Activity.showInputMethod(){
    (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).apply {
        showSoftInput(findViewById(android.R.id.content), InputMethodManager.SHOW_FORCED)
    }
}

fun Activity.hideInputMethod(){
    (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).run {
        hideSoftInputFromWindow(findViewById<View>(android.R.id.content).windowToken, 0)
    }
}


