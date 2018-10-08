package com.lxj.qingframework

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger.addLogAdapter
import com.orhanobut.logger.PrettyFormatStrategy


object QingFramework {
    init {
    }

    /**
     * 配置logger
     */
    fun configLog(isEnableLog: Boolean = true,
                  logTag: String = "PRETTY_LOGGER",
                  showThreadInfo: Boolean = true,
                  methodCount: Int = 2): QingFramework {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(showThreadInfo)   // (Optional) Whether to show thread info or not. Default true
                .methodCount(methodCount)         // (Optional) How many method line to show. Default 2
//                .methodOffset(7)                // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(customLog)         // (Optional) Changes the log strategy to print out. Default LogCat
                .tag(logTag)                      // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build()
        addLogAdapter(object : AndroidLogAdapter(formatStrategy){
            override fun isLoggable(priority: Int, tag: String?) = isEnableLog
        })
        return this
    }
}