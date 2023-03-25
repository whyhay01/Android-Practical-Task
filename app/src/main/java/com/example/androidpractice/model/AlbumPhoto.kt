package com.example.androidpractice.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "albumphoto")
data class AlbumPhoto(
    @PrimaryKey val albumId: Int,
    val id: Int,
    val title: String,
    @SerializedName("url")
    val imageUrl: String,
    val thumbnailUrl: String
):Parcelable