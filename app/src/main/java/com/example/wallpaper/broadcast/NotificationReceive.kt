package com.example.wallpaper.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NotificationReceive :BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val message = intent?.getStringExtra("MESSAGE")
        if(message != null){
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}