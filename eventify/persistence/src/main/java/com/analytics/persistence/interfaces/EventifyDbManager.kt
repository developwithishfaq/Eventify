package com.analytics.persistence.interfaces

import android.content.Context
import com.analytics.persistence.daos.SessionDao
import com.analytics.persistence.models.DatabaseConfig

interface EventifyDbManager {
    fun initializeDb(context: Context, config: DatabaseConfig = DatabaseConfig())
    fun getSessionsDao(): SessionDao?
}