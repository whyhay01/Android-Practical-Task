package com.example.androidpractice.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "albumphoto")
data class AlbumPhotoUIObject(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val title: String,
    val albumPhotos: List<AlbumPhoto>
    ): Parcelable
