package com.lxj.gayhub.ui.widget.iconfont

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView


class IconFontRadioButton(context: Context, attrs: AttributeSet?) : RadioButton(context, attrs) {
    init {
        typeface = Typeface.createFromAsset(context.assets, "fonts/iconfont.ttf")
        includeFontPadding = false
    }
}