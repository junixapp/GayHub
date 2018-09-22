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

    fun title(title: String){
        page_title.text = title
    }

    fun hide(){
        visibility = View.GONE
    }

    fun addActionButton(actionBtn1: String? = null,
                        actionBtn2: String? = null,
                        actionBtn3: String? = null){
        if(actionBtn1!=null){
            action1.text = actionBtn1
            action1.visibility = View.VISIBLE
        }
        if(actionBtn2!=null){
            action2.text = actionBtn2
            action2.visibility = View.VISIBLE
        }
        if(actionBtn3!=null){
            action3.text = actionBtn3
            action3.visibility = View.VISIBLE
        }
    }

    interface OnActionClickListener{
        fun onAction1Click(){}
        fun onAction2Click(){}
        fun onAction3Click(){}
    }
}