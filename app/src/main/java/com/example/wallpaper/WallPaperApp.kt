package com.example.wallpaper

import android.app.Application
import com.example.wallpaper.data.dataSource.SecureStorageManager
import com.example.wallpaper.database.AppDatabase
import com.example.wallpaper.database.WallPaperDaoRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class WallPaperApp :Application() {


@Inject
lateinit var secureStorageManager: SecureStorageManager
    override fun onCreate() {
        super.onCreate()
        secureStorageManager.token = "563492ad6f91700001000001c067ee734b8c43258d647f856b713f90"
    }
}