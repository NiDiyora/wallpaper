package com.example.wallpaper.ktor

import com.example.wallpaper.ktor.model.Cultured
import io.ktor.client.request.*

class GetRepo :GetRepoImpl{
    override suspend fun getWallPaper(page:Int,per_page:Int): Cultured = KtorClient.httpClient.get("https://api.pexels.com/v1/curated?page=2&per_page=200"){
        headers{
            append("Authorization","563492ad6f91700001000001c067ee734b8c43258d647f856b713f90")
        }
        parameter("page",page)
        parameter("per_page",per_page)
    }
}