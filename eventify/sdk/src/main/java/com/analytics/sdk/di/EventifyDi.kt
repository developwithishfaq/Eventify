package com.analytics.sdk.di

import android.content.Context
import com.analytics.data.SessionsRepositoryImpl
import com.analytics.domain.SessionsRepository
import com.analytics.persistence.interfaces.EventifyDbManager
import com.analytics.persistence.manager.EventifyDbManagerImpl
import com.analytics.persistence.models.DatabaseConfig

object EventifyDi {

    private var dbManager: EventifyDbManager? = null
    private var sessionsRepository: SessionsRepository? = null

    fun init(context: Context, config: DatabaseConfig = DatabaseConfig()) {
        val dbManagerImpl = EventifyDbManagerImpl()
        dbManagerImpl.initializeDb(context, config)
        dbManager = dbManagerImpl
        dbManager?.let {
            sessionsRepository = SessionsRepositoryImpl(it.getSessionsDao()!!)
        }
    }

    fun getSessionsRepository(): SessionsRepository {
        return sessionsRepository ?: throw IllegalStateException("Eventify not initialized")
    }


}