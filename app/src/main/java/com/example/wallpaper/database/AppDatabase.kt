package com.example.wallpaper.database

import android.content.Context
import androidx.room.*
import com.example.wallpaper.comman.Converter
import com.example.wallpaper.ktor.model.Cultured

@Database(entities = [Cultured::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppDatabase :RoomDatabase(){
    abstract fun wallpaperDao(): WallPaperDao

    companion object{

        private var INSTANCE:AppDatabase?= null

        fun getDataBase(context: Context) : AppDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "word_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
}