package me.guaidaodl.mobile.log

import android.util.Log

object Log {
    private val loggers = mutableListOf<Logger>()

    @JvmStatic
    fun addLogger(logger: Logger) {
        loggers.add(logger)
    }

    @JvmStatic
    fun removeLogger(logger: Logger) {
        loggers.remove(logger)
    }

    @JvmStatic
    fun v(tag: String, msg: String) {
        loggers.forEach { it.log(LOGGER_LEVEL_VERBOSE, tag, msg) }
    }

    @JvmStatic
    fun d(tag: String, msg: String) {
        loggers.forEach { it.log(LOGGER_LEVEL_DEBUG, tag, msg) }
    }

    @JvmStatic
    fun i(tag: String, msg: String) {
        loggers.forEach { it.log(LOGGER_LEVEL_VERBOSE, tag, msg) }
    }

    @JvmStatic
    fun w(tag: String, msg: String) {
        loggers.forEach { it.log(LOGGER_LEVEL_WARN, tag, msg) }
    }

    @JvmStatic
    fun e(tag: String, msg: String) {
        loggers.forEach { it.log(LOGGER_LEVEL_ERROR, tag, msg) }
    }

    @JvmStatic
    fun e(tag: String, msg: String, tr: Throwable) {
        loggers.forEach {
            it.log(
                LOGGER_LEVEL_ERROR, tag,
                "$msg\n${Log.getStackTraceString(tr)}"
            )
        }
    }
    @JvmStatic
    fun wtf(tag: String, msg: String) {
        loggers.forEach { it.log(LOGGER_LEVEL_WTF, tag, msg) }
    }

}