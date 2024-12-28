package com.analytics.persistence.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SessionEntity(
    @PrimaryKey
    val sessionId: String,
    val sessionStartTime: Long,
    val sessionEndTime: Long,
    val totalForegroundTime: Long,
    val noOfReOpens: Int,
)
