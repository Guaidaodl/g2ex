package me.guaidaodl.mobile.log

const val LOGGER_LEVEL_VERBOSE = 1
const val LOGGER_LEVEL_DEBUG = 2
const val LOGGER_LEVEL_INFO = 3
const val LOGGER_LEVEL_WARN = 4
const val LOGGER_LEVEL_ERROR = 5
const val LOGGER_LEVEL_WTF = 6

interface Logger {
    fun log(logLevel: Int, tag: String, message: String)
}