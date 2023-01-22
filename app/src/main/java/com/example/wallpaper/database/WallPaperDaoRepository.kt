package com.example.wallpaper.database

import com.example.wallpaper.ktor.model.Cultured
import kotlinx.coroutines.flow.Flow

class WallPaperDaoRepository constructor(val wallPaperDao: WallPaperDao) {

   suspend fun insertCulturedWallpaper(cultured: Cultured){
        wallPaperDao.insertCulturedWallpaper(cultured)
    }

     fun getCulturedWallPaper():Flow<Cultured>{
      return  wallPaperDao.getCulturedWallpaper()
    }
}