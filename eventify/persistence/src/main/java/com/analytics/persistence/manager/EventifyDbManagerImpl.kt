package com.analytics.persistence.manager

import android.content.Context
import androidx.room.Room
import com.analytics.persistence.EventifyDb
import com.analytics.persistence.daos.SessionDao
import com.analytics.persistence.interfaces.EventifyDbManager
import com.analytics.persistence.models.DatabaseConfig

class EventifyDbManagerImpl : EventifyDbManager {
    private var database: EventifyDb? = null
    override fun initializeDb(context: Context, config: DatabaseConfig) {
        if (database == null) {
            database = Room.databaseBuilder(
                context = context,
                klass = EventifyDb::class.java,
                name = config.databaseName
            ).build()
        }
    }

    override fun getSessionsDao(): SessionDao? {
        return database?.getSessionsDao()
    }
}