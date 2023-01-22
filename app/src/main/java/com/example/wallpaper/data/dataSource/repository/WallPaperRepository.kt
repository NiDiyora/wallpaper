package com.example.wallpaper.data.dataSource.repository

import com.example.wallpaper.ktor.model.Cultured
import io.reactivex.rxjava3.core.Single

interface WallPaperRepository {

    fun getWallPaper(page: Int, per_page: Int): Single<Cultured>

}