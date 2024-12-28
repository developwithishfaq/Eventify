package com.analytics.domain

import com.analytics.domain.model.SessionModel

interface SessionsRepository {
    suspend fun createOrUpdateSession(model: SessionModel): Long
}