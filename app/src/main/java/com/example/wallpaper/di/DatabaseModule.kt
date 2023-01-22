package com.example.wallpaper.di

import android.content.Context
import androidx.room.Room
import com.example.wallpaper.data.dataSource.IPreferencesStorage
import com.example.wallpaper.data.dataSource.ISecureStorageManager
import com.example.wallpaper.data.dataSource.PreferencesStorage
import com.example.wallpaper.data.dataSource.SecureStorageManager
import com.example.wallpaper.database.AppDatabase
import com.example.wallpaper.database.WallPaperDao
import com.example.wallpaper.database.WallPaperDaoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun ProvideSecureStorageManager(@ApplicationContext context: Context): ISecureStorageManager =
        SecureStorageManager(context)

    @Singleton
    @Provides
    fun ProvideSharedPreferences(@ApplicationContext context: Context): IPreferencesStorage =
        PreferencesStorage(context)


//    @Provides
//     fun provideWallPaperDaoRepository(@ApplicationContext appContext: Context): WallPaperDaoRepository {
//         return WallPaperDaoRepository(wallPaperDao = AppDatabase.getDataBase(context = appContext).wallpaperDao())
//    }
//    @Provides
//    @Singleton
//    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
//        return Room.databaseBuilder(
//            appContext,
//            AppDatabase::class.java,
//            "wallpaper_db"
//        ).build()
//    }

//    @Provides
//    fun provideWallpaperDao(appDatabase: AppDatabase): WallPaperDao {
//        return appDatabase.wallpaperDao()
//    }
}