package com.example.wallpaper.di

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.*
import androidx.core.app.NotificationManagerCompat
import androidx.core.net.toUri
import com.example.wallpaper.MainActivity
import com.example.wallpaper.R
import com.example.wallpaper.broadcast.NotificationReceive
import com.example.wallpaper.comman.MY_URI
import com.example.wallpaper.comman.My_Arg
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NotificationBuilder {


    @Singleton
    @Provides
    @MainNotificationBuilder
    fun ProvideNotificatiomBuilder(@ApplicationContext context: Context): Builder {

        val intent = Intent(context, NotificationReceive::class.java).apply {
            putExtra("MESSAGE", "clicked")
        }

        val flag = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.FLAG_IMMUTABLE
        } else {
            0
        }
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, flag)

//        val clickIntent = Intent(context, MainActivity::class.java)
//        val clickPendingIntent = PendingIntent.getActivity(
//            context,
//            0,
//            clickIntent,
//            flag
//        )

        val clickIntent = Intent(
            Intent.ACTION_VIEW,
            "$MY_URI/$My_Arg=coming from notification".toUri(),
            context,
            MainActivity::class.java
        )
        val clickPendingIntent = TaskStackBuilder.create(context).run {
            addNextIntentWithParentStack(clickIntent)
            getPendingIntent(1, flag)
        }
        return Builder(context, "Main Channel ID").setContentTitle("welcome")
            .setContentText("Nirgav Diyora").setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setPriority(PRIORITY_DEFAULT).setVisibility(VISIBILITY_PUBLIC).setPublicVersion(
                Builder(context, "Main Channel ID").setContentTitle("hidden")
                    .setContentText("Unable see message please unlock device").build()
            ).addAction(0, "Action", pendingIntent).setContentIntent(clickPendingIntent)

    }

    @Singleton
    @Provides
    @SecondNotificationBuilder
    fun ProvideSecondNotificationBuilder(@ApplicationContext context: Context) : NotificationCompat.Builder{
        return Builder(context,"Second Channel ID").setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setPriority(PRIORITY_LOW)
            .setOngoing(true)
    }


    @Singleton
    @Provides
    fun ProvideNotificationManager(@ApplicationContext context: Context): NotificationManagerCompat {
        val notificationManager = NotificationManagerCompat.from(context)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "Main Channel ID", "Main Channel", NotificationManager.IMPORTANCE_DEFAULT
            )
            val channel1 = NotificationChannel(
                "Second Channel ID", "Second Channel", NotificationManager.IMPORTANCE_LOW
            )
            notificationManager.createNotificationChannel(channel)
            notificationManager.createNotificationChannel(channel1)
        }
        return notificationManager
    }



}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainNotificationBuilder

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SecondNotificationBuilder