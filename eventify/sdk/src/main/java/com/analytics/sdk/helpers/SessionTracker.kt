package com.analytics.sdk.helpers

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import java.util.UUID

internal class SessionTracker : DefaultLifecycleObserver {

    private var sessionStartTime = 0L
    private var totalPauseDuration = 0L
    private var lastPauseTime = 0L
    private var sessionId = ""

    fun init() {
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        sessionStartTime = System.currentTimeMillis()
        sessionId = UUID.randomUUID().toString()
        Log.d("cvv", "onCreate: Lifecycle")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        if (lastPauseTime != 0L) {
            totalPauseDuration += System.currentTimeMillis() - lastPauseTime
            Log.d("cvv", "onStart: Resumed after pause")
        }
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        lastPauseTime = System.currentTimeMillis()
        val sessionDuration = (lastPauseTime - sessionStartTime - totalPauseDuration) / 1000

        Log.d("cvv", "onPause: Session duration=$sessionDuration seconds")
    }
}
