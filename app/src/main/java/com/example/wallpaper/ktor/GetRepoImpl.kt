package com.example.wallpaper.ktor

import com.example.wallpaper.ktor.model.Cultured

interface GetRepoImpl  {
    suspend fun getWallPaper(page:Int,per_page:Int): Cultured

}