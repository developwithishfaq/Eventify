/*
package com.analytics.sdk.helpers

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.util.Log

class SessionTrackerInitializer : ContentProvider() {
    private var sessionTracker: SessionTracker? = null

    override fun onCreate(): Boolean {
        Log.d("cvv", "onCreate: SessionTrackerInitializer")
        if (sessionTracker == null) {
            sessionTracker = SessionTracker()
        }
        sessionTracker?.init()
        return false
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        return null
    }

    override fun getType(p0: Uri): String? {
        return null
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        return null
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        return 0
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        return 0
    }

}*/
