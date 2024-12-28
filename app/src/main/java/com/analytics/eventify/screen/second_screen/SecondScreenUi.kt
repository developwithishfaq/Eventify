package com.analytics.eventify.screen.second_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SecondScreenUi(
    popBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text("Main Screen")
        Button(
            onClick = {
                popBack.invoke()
            }
        ) {
            Text("Go Back")
        }
    }
}