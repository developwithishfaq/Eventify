package com.analytics.sdk

import android.app.Application
import com.analytics.sdk.di.EventifyDi
import com.analytics.sdk.helpers.InteractionTracker
import com.analytics.sdk.helpers.SessionTracker

object EventifySdk {
    private var sdkInitialized = false

    private var sessionTracker: SessionTracker? = null

    fun init(app: Application) {
        if (sdkInitialized) {
            return
        }
        initAll(app)
        sdkInitialized = true
    }

    private fun initAll(app: Application) {
        EventifyDi.init(app)
        initSessionTracker()
        InteractionTracker.init(app)
    }

    private fun initSessionTracker() {
        if (sessionTracker == null) {
            sessionTracker = EventifyDi.getSessionsRepository()
                ?.let { SessionTracker(it, EventifyDi.getLogger()) }
        }
        sessionTracker?.init()
    }

}