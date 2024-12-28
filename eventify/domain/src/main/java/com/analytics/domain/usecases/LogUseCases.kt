package com.analytics.domain.usecases

import com.analytics.domain.repositories.Logger


fun Logger.logIt(msg: String) {
    log("cvv", msg)
}