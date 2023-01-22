package com.example.wallpaper.presentation.alaramManeger

interface AlarmScheduler {
    fun schedule(item: AlarmItem)
    fun cancel(item: AlarmItem)
}