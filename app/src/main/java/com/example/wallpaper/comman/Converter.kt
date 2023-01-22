package com.example.wallpaper.comman

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.wallpaper.ktor.model.Photo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

internal class Converter {
    val gson = Gson()
    @TypeConverter
    fun photoListToString(photos: List<Photo>): String{
        return gson.toJson(photos)
    }


    @TypeConverter
    fun stringToPhoto(photos: String): List<Photo> {
        val type: Type = object : TypeToken<List<Photo>>() {}.type
        return gson.fromJson(photos, type)
    }

}