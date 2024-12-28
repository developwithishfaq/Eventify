package com.analytics.eventify.navigation

import kotlinx.serialization.Serializable

sealed interface Routes {

    @Serializable
    data object MainScreen : Routes

    @Serializable
    data object SecondScreen : Routes

}