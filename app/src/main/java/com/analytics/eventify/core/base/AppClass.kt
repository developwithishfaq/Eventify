package com.analytics.eventify.core.base

import android.app.Application
import android.util.Log

class AppClass : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("cvv", "AppClass onCreate: Lifecycle")
    }
}
