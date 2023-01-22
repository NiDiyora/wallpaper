package com.example.wallpaper.data.dataSource.remote.api

import com.example.wallpaper.ktor.model.Cultured
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("curated")
    fun getWallPaper(@Query("page") page: Int = 0, @Query("per_page") per_page: Int = 80) : Single<Cultured>
}