package com.example.wallpaper.data.dataSource

import com.example.wallpaper.data.dataSource.remote.api.ApiService
import com.example.wallpaper.ktor.model.Cultured
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WallPaperRemoteDataSourceImpl @Inject constructor(private val apiService: ApiService):WallPaperRemoteDataSource{
    override fun getWallPaper(page: Int, per_page: Int): Single<Cultured> {
       return apiService.getWallPaper(page,per_page)
    }
}