package com.analytics.domain.model

data class SessionModel(
    val sessionId: String,
    val sessionStartTime: Long,
    val sessionEndTime: Long,
    val sessionForegroundTime: Long,
    val noOfReOpens: Int,
)
