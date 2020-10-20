package me.guaidaodl.mobile.common.utils

import android.app.Application
import android.content.Context

object AppUtils {
    private lateinit var application: Application

    @JvmStatic
    fun init(application: Application) {
        this.application = application
    }

    @JvmStatic
    fun appContext(): Context = application
}