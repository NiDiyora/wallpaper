package com.example.wallpaper.data.dataSource.repository

import com.example.wallpaper.data.dataSource.WallPaperRemoteDataSource
import com.example.wallpaper.ktor.model.Cultured
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WallPaperRepositoryImpl @Inject constructor(private val wallPaperRemoteDataSource: WallPaperRemoteDataSource) :
    WallPaperRepository {
    override fun getWallPaper(page: Int, per_page: Int): Single<Cultured> {
        return wallPaperRemoteDataSource.getWallPaper(page, per_page)
    }
}