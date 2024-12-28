package com.analytics.sdk.helpers

import android.app.Activity
import android.app.Application
import android.os.Bundle

internal class InteractionTracker private constructor() {
    companion object {
        fun init(application: Application) {
            application.registerActivityLifecycleCallbacks(object :
                Application.ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                    val originalCallback = activity.window.callback
                    activity.window.callback = UserInteractionTracker(originalCallback)
                }

                override fun onActivityStarted(activity: Activity) {}
                override fun onActivityResumed(activity: Activity) {}
                override fun onActivityPaused(activity: Activity) {}
                override fun onActivityStopped(activity: Activity) {}
                override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
                override fun onActivityDestroyed(activity: Activity) {}
            })
        }
    }
}
