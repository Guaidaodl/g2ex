package me.guaidaodl.mobile.log.impl

import android.util.Log
import me.guaidaodl.mobile.log.*

class LogcatLogger : Logger {
    override fun log(logLevel: Int, tag: String, message: String) {
        when(logLevel) {
            LOGGER_LEVEL_VERBOSE -> Log.v(tag, message)
            LOGGER_LEVEL_DEBUG -> Log.d(tag, message)
            LOGGER_LEVEL_INFO -> Log.i(tag, message)
            LOGGER_LEVEL_WARN -> Log.w(tag, message)
            LOGGER_LEVEL_ERROR -> Log.e(tag, message)
            LOGGER_LEVEL_WTF -> Log.wtf(tag, message)
        }
    }
}