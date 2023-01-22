package com.example.wallpaper.viewmodals

import android.app.Notification
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallpaper.di.MainNotificationBuilder
import com.example.wallpaper.di.NotificationBuilder
import com.example.wallpaper.di.SecondNotificationBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(
   @MainNotificationBuilder private val notificationBuilder: NotificationCompat.Builder,
    @SecondNotificationBuilder private val notificationBuilder1: NotificationCompat.Builder,
    private val notificationManager: NotificationManagerCompat
) : ViewModel() {

    fun simpleNotificationGenerate() {
        notificationManager.notify(1, notificationBuilder.build())
    }

    fun updateNotification() {
        notificationManager.notify(
            1,
            notificationBuilder.setContentTitle("Wallpaper")
                .setContentText("Android Studio is the official Integrated Development Environment (IDE) for Android app development, based on IntelliJ IDEA . On top of IntelliJ's powerful code editor and developer tools, Android Studio offers even more features that enhance your productivity when building Android apps, such as:")
                .build()
        )
    }

    fun cancel() {
        notificationManager.cancelAll()
    }

    fun progress() {
        val max = 10
        var progress = 0
        viewModelScope.launch {
            while (progress != max) {
                delay(1000)
                progress += 1
                notificationManager.notify(
                    3,
                    notificationBuilder1.setContentTitle("Downloading")
                        .setContentText("${progress}/${max}").setProgress(max, progress, false)
                        .build()
                )
            }
            notificationManager.notify(
                3,
                notificationBuilder.setContentTitle("Completed!!")
                    .setContentText("").setContentIntent(null)
                    .clearActions()
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setProgress(0, 0, false).build()
            )
        }
    }
}