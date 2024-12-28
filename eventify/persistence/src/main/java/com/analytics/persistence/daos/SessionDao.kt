package com.analytics.persistence.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.analytics.persistence.models.SessionEntity

@Dao
interface SessionDao {

    @Upsert
    suspend fun upsertSessions(sessionEntity: SessionEntity): Long

    @Query("SELECT * FROM SessionEntity WHERE sessionId=:sessionId")
    suspend fun getSessionById(sessionId: String): SessionEntity?


}