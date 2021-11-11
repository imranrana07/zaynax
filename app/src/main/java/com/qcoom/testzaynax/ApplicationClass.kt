package com.qcoom.testzaynax

import android.app.Application
import android.content.Context

class ApplicationClass: Application() {
    companion object{
        var AppContext: Context? = null
    }
    override fun onCreate() {
        super.onCreate()
        AppContext = applicationContext
    }
}