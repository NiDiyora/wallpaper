package com.example.wallpaper.di

import com.example.wallpaper.data.dataSource.WallPaperRemoteDataSource
import com.example.wallpaper.data.dataSource.WallPaperRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {
    @Binds
    abstract fun provideWallPaperRemoteDataSource(wallPaperRemoteDataSourceImpl: WallPaperRemoteDataSourceImpl): WallPaperRemoteDataSource
}