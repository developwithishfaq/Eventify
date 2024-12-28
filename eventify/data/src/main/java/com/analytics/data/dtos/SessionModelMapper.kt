package com.analytics.data.dtos

import com.analytics.domain.model.SessionModel
import com.analytics.persistence.models.SessionEntity


fun SessionModel.toSessionEntity(): SessionEntity {
    return SessionEntity(
        -1,
        sessionId = sessionId,
        sessionStartTime = sessionStartTime,
        sessionEndTime = sessionEndTime,
        totalForegroundTime = sessionForegroundTime
    )
}

fun SessionEntity.toSessionModel(): SessionModel {
    return SessionModel(
        sessionId = sessionId,
        sessionStartTime = sessionStartTime,
        sessionEndTime = sessionEndTime,
        sessionForegroundTime = totalForegroundTime
    )
}