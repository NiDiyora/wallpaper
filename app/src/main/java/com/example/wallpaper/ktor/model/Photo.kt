package com.example.wallpaper.ktor.model

import androidx.room.Embedded
import androidx.room.PrimaryKey

@kotlinx.serialization.Serializable
data class Photo(
    val alt: String?,
    val avg_color: String?,
    val height: Int?,
    val id: Int?,
    val liked: Boolean?,
    val photographer: String?,
    val photographer_id: Int?,
    val photographer_url: String?,
    @Embedded val src: Src?,
    val url: String?,
    val width: Int?
)