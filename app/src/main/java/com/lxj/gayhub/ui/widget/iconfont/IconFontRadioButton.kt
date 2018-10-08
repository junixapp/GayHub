package com.lxj.gayhub.ui.widget.iconfont

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView


class IconFontTextView(context: Context, attrs: AttributeSet?) : TextView(context, attrs) {
    init {
        typeface = Typeface.createFromAsset(context.assets, "fonts/iconfont.ttf")
        includeFontPadding = false
    }
}