package com.android.main

import android.app.Application
import com.llj.baselib.IOTLib
import com.llj.baselib.bean.UserConfigBean

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val bean = UserConfigBean(
            userId = "19192",
            appKey = "c62c88d457",
            deviceId = "25918",
            clientId = "1207",
            clientSecret = "dc8e50531e"
        )
        IOTLib.init(applicationContext,bean)
    }

    companion object{
        const val DEV_SP = "DEV_SP"
        const val DEV_ID_SP = "DEV_ID_SP"
    }

}