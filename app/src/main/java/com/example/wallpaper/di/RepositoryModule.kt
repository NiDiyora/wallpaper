package com.example.wallpaper.di

import com.example.wallpaper.data.dataSource.repository.WallPaperRepository
import com.example.wallpaper.data.dataSource.repository.WallPaperRepositoryImpl
import com.example.wallpaper.database.WallPaperDaoRepository

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun ProvideGetRepo(wallPaperRepositoryImpl: WallPaperRepositoryImpl):WallPaperRepository


//    @Binds
//    abstract fun ProvideGetRepo1(getRepoImpl: GetRepoImpl):GetRepo
}