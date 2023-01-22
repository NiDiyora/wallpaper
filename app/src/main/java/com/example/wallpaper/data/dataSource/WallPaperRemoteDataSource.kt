package com.example.wallpaper.data.dataSource

import com.example.wallpaper.ktor.model.Cultured
import io.reactivex.rxjava3.core.Single
import javax.inject.Singleton

interface WallPaperRemoteDataSource {

    fun getWallPaper(page: Int, per_page: Int):Single<Cultured>
}