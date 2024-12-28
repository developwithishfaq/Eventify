package com.analytics.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.analytics.persistence.daos.SessionDao
import com.analytics.persistence.models.SessionEntity

@Database(entities = [SessionEntity::class], version = 1)
abstract class EventifyDb : RoomDatabase() {
    abstract fun getSessionsDao() : SessionDao
}