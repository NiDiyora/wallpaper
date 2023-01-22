package com.example.wallpaper.ktor.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.wallpaper.comman.Converter

@kotlinx.serialization.Serializable
@Entity(tableName = "wallpaper_photos")
data class Cultured(
    @PrimaryKey(autoGenerate = true) val wp_id:Int? =0,
    val next_page: String?,
    val page: Int?,
    val per_page: Int?,
    val photos: List<Photo>?,
    val total_results: Int?
)