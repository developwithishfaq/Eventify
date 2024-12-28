package com.analytics.data

import com.analytics.data.dtos.toSessionEntity
import com.analytics.data.dtos.toSessionModel
import com.analytics.domain.model.SessionModel
import com.analytics.domain.repositories.Logger
import com.analytics.domain.repositories.SessionsRepository
import com.analytics.domain.usecases.logIt
import com.analytics.persistence.daos.SessionDao

class SessionsRepositoryImpl(
    private val sessionDao: SessionDao,
    private val logger: Logger
) : SessionsRepository {
    override suspend fun createOrUpdateSession(model: SessionModel): Long {
        logger.logIt("createOrUpdateSession called $model")
        return sessionDao.upsertSessions(model.toSessionEntity())
    }

    override suspend fun getSessionModelById(id: String): SessionModel? {
        return sessionDao.getSessionById(id)?.toSessionModel()
    }
}