package com.analytics.data

import android.util.Log
import com.analytics.domain.repositories.Logger

class LoggerImpl : Logger {
    override fun log(tag: String, msg: String) {
        Log.d(tag, msg)
    }

    override fun logError(tag: String, msg: String) {
        Log.d(tag, msg)
    }
}