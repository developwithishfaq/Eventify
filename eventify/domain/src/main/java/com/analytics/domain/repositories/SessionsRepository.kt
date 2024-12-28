package com.analytics.domain.repositories

import com.analytics.domain.model.SessionModel

interface SessionsRepository {
    suspend fun createOrUpdateSession(model: SessionModel): Long
    suspend fun getSessionModelById(id: String): SessionModel?
}