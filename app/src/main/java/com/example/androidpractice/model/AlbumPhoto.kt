package com.example.androidpractice.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "albumphoto")
data class AlbumPhoto(
    val albumId:Int,
    @PrimaryKey val id:Int,
    val title:String,
    @SerializedName("url")
    val imageUrl:String,
    val thumbnailUrl:String
)