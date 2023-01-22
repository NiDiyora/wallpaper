package com.example.wallpaper.presentation.HomePage

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.wallpaper.comman.Screens
import com.example.wallpaper.viewmodals.NotificationViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: NotificationViewModel = hiltViewModel()) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { viewModel.simpleNotificationGenerate() },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Simple Notification Generate")
            }
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Button(
                onClick = { viewModel.updateNotification() },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "update Notification")
            }
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Button(
                onClick = { viewModel.progress() },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Progress Notification")
            }
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Button(
                onClick = { navController.navigate(Screens.HomeDetailsScreen.passArgument(message = "coming main for Main screen")) },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Notification Details")
            }
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Button(
                onClick = { viewModel.cancel() },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Notification Cancel")
            }
        }
    }
}
 