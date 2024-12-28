package com.analytics.data

import com.analytics.data.dtos.toSessionEntity
import com.analytics.domain.SessionsRepository
import com.analytics.domain.model.SessionModel
import com.analytics.persistence.daos.SessionDao

class SessionsRepositoryImpl(
    private val sessionDao: SessionDao
) : SessionsRepository {
    override suspend fun createOrUpdateSession(model: SessionModel): Long {
        return sessionDao.upsertSessions(model.toSessionEntity())
    }
}