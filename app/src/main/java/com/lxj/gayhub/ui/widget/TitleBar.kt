package com.lxj.gayhub.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.lxj.gayhub.R
import org.jetbrains.anko.toast

class TitleBar(context: Context?, attrs: AttributeSet?) : FrameLayout(context, attrs) {


    init {
        View.inflate(context, R.layout.layout_titlebar, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        context.toast(""+childCount)
    }
}