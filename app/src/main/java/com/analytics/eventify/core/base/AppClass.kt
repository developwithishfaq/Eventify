package com.analytics.eventify.core.base

import android.app.Application
import android.util.Log
import com.analytics.sdk.EventifySdk

class AppClass : Application() {
    override fun onCreate() {
        super.onCreate()
        EventifySdk.init(this)
        Log.d("cvv", "AppClass onCreate: Lifecycle")
    }
}
