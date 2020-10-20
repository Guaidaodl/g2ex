package me.guaidaodl.g2ex

import android.app.Application
import android.content.Context
import me.guaidaodl.mobile.common.utils.AppUtils
import me.guaidaodl.mobile.log.Log
import me.guaidaodl.mobile.log.impl.LogcatLogger

class G2exApplication : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Log.addLogger(LogcatLogger())
    }

    override fun onCreate() {
        super.onCreate()
        AppUtils.init(this)
    }
}