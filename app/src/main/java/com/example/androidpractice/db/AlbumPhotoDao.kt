package com.example.androidpractice.db

import androidx.room.Dao
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.androidpractice.model.AlbumPhoto
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumPhotoDao {
    @Query("SELECT * FROM albumphoto")
    fun getAlbumPhotos():Flow<List<AlbumPhoto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlbumPhotos(item: List<AlbumPhoto>)

    @Query("DELETE FROM albumphoto")
    suspend fun deleteAlbumPhotos():Unit
}