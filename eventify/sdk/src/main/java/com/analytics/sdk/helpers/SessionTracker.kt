package com.analytics.sdk.helpers

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import com.analytics.domain.repositories.Logger
import com.analytics.domain.repositories.SessionsRepository
import com.analytics.domain.usecases.createSession
import com.analytics.domain.usecases.logIt
import com.analytics.domain.usecases.updateSessionModel
import java.util.UUID

internal class SessionTracker(
    private val sessionsRepository: SessionsRepository,
    private val logger: Logger
) : DefaultLifecycleObserver {

    private var sessionStartTime = 0L
    private var totalPauseDuration = 0L
    private var lastPauseTime = 0L
    private var noOfReOpens = 0
    private var sessionDuration = 0L
    private var sessionId = ""

    fun init() {
        sessionsRepository.createSession(sessionId = getSessionId(), startTime = sessionStartTime)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    private fun getSessionId(): String {
        if (sessionId.isBlank()) {
            sessionId = UUID.randomUUID().toString()
        }
        if (sessionStartTime <= 0L) {
            sessionStartTime = System.currentTimeMillis()
        }
        return sessionId
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        logger.logIt("onCreate: Lifecycle")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        if (lastPauseTime != 0L) {
            noOfReOpens += 1
            totalPauseDuration += (System.currentTimeMillis() - lastPauseTime) + 2
            logger.logIt("onStart: Resumed after pause")

        }
        sessionsRepository.updateSessionModel(
            sessionId = getSessionId(),
            startTime = sessionStartTime,
            endTime = lastPauseTime,
            duration = sessionDuration,
            noOfReOpens = noOfReOpens
        )
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        lastPauseTime = System.currentTimeMillis()
        sessionDuration = ((lastPauseTime - sessionStartTime - totalPauseDuration) / 1000)

        sessionsRepository.updateSessionModel(
            sessionId = getSessionId(),
            startTime = sessionStartTime,
            endTime = lastPauseTime,
            duration = sessionDuration,
            noOfReOpens = noOfReOpens
        )
        logger.logIt("onPause: Session duration=$sessionDuration seconds")
    }
}
