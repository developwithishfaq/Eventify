package com.analytics.sdk.di

import android.content.Context
import com.analytics.data.LoggerImpl
import com.analytics.data.SessionsRepositoryImpl
import com.analytics.domain.repositories.Logger
import com.analytics.domain.repositories.SessionsRepository
import com.analytics.persistence.interfaces.EventifyDbManager
import com.analytics.persistence.manager.EventifyDbManagerImpl
import com.analytics.persistence.models.DatabaseConfig
import com.analytics.sdk.helpers.SessionTracker

object EventifyDi {

    private var dbManager: EventifyDbManager? = null
    private var logger: Logger? = null
    private var sessionsRepository: SessionsRepository? = null
    private var sessionTracker: SessionTracker? = null

    fun init(context: Context, config: DatabaseConfig = DatabaseConfig()) {
        val dbManagerImpl = EventifyDbManagerImpl()
        dbManagerImpl.initializeDb(context, config)
        dbManager = dbManagerImpl
        logger = LoggerImpl()
        dbManager?.let {
            sessionsRepository = SessionsRepositoryImpl(it.getSessionsDao()!!, getLogger())
        }
    }

    fun getSessionsRepository(): SessionsRepository? {
        return sessionsRepository
    }

    fun getLogger(): Logger {
        return logger ?: run {
            logger = LoggerImpl()
            logger!!
        }
    }


}