package com.example.wallpaper.ktor

import com.example.wallpaper.ktor.model.Cultured
import javax.inject.Inject

class WallpaperRemoteDataSource @Inject constructor(private val getRepo: GetRepo): WallpaperRemoteDataSourceImpl {
    override suspend fun getWallPaper(page:Int,per_page:Int): Cultured {
        return getRepo.getWallPaper(page,per_page)
    }

}