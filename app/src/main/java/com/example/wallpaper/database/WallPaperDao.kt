package com.example.wallpaper.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.wallpaper.ktor.model.Cultured
import kotlinx.coroutines.flow.Flow

@Dao
interface WallPaperDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertCulturedWallpaper(cultured: Cultured)

   @Query("SELECT * FROM wallpaper_photos")
   fun getCulturedWallpaper():Flow<Cultured>
}