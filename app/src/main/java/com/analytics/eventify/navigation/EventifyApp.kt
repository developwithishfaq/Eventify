package com.analytics.eventify.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.analytics.eventify.screen.main_screen.MainScreen
import com.analytics.eventify.screen.second_screen.SecondScreenUi

@Composable
fun EventifyApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.MainScreen
    ) {
        composable<Routes.MainScreen> {
            MainScreen(moveToSecondScreen = {
                navController.navigate(Routes.SecondScreen)
            })
        }
        composable<Routes.SecondScreen> {
            SecondScreenUi(popBack = {
                navController.popBackStack()
            })
        }
    }
}