package com.lxj.gayhub.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.lxj.gayhub.R
import kotlinx.android.synthetic.main.layout_titlebar.view.*

class TitleBar(context: Context?, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    var actionClickListener: OnActionClickListener? = null

    init {
        View.inflate(context, R.layout.layout_titlebar, this)

        action1.setOnClickListener{
            actionClickListener?.onAction1Click()
        }
        action2.setOnClickListener{
            actionClickListener?.onAction2Click()
        }
        action3.setOnClickListener{
            actionClickListener?.onAction3Click()
        }
    }

    fun addActionButton(actionBtn1: String = "",
                        actionBtn2: String = "",
                        actionBtn3: String = ""){
        action1.text = actionBtn1
        action2.text = actionBtn2
        action3.text = actionBtn3
    }

    interface OnActionClickListener{
        fun onAction1Click(){}
        fun onAction2Click(){}
        fun onAction3Click(){}
    }
}