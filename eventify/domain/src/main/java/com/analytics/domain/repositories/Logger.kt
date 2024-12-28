package com.analytics.domain.repositories

interface Logger {
    fun log(tag: String, msg: String)
    fun logError(tag: String, msg: String)
}