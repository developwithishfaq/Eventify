package com.analytics.domain.usecases

import com.analytics.domain.model.SessionModel
import com.analytics.domain.repositories.SessionsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun SessionsRepository.createSession(
    sessionId: String,
    startTime: Long,
) {
    CoroutineScope(Dispatchers.IO).launch {
        val session = getSessionModelById(sessionId)
        if (session != null) {
            return@launch
        }
        createOrUpdateSession(
            SessionModel(
                sessionId = sessionId,
                sessionStartTime = startTime,
                sessionEndTime = startTime,
                sessionForegroundTime = 0,
                noOfReOpens = 0
            )
        )
    }
}

fun SessionsRepository.updateSessionModel(
    sessionId: String,
    startTime: Long,
    endTime: Long,
    duration: Long,
    noOfReOpens: Int,
) {
    CoroutineScope(Dispatchers.IO).launch {
        createOrUpdateSession(
            SessionModel(
                sessionId = sessionId,
                sessionStartTime = startTime,
                sessionEndTime = endTime,
                sessionForegroundTime = duration,
                noOfReOpens = noOfReOpens
            )
        )
    }
}