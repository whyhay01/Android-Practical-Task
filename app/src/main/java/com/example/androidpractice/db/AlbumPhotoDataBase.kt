package com.example.androidpractice.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidpractice.model.AlbumPhoto

@Database(entities = [AlbumPhoto::class], version = 1)
abstract class AlbumPhotoDataBase: RoomDatabase() {
    abstract fun albumPhotoDao():AlbumPhotoDao

    companion object{
        private var userDatabaseInstance: AlbumPhotoDataBase? = null



    fun getDatabaseInstance(context: Context):AlbumPhotoDataBase?{
        if (userDatabaseInstance == null) {

            synchronized(AlbumPhotoDataBase::class.java) {
                if (userDatabaseInstance == null) {
                    userDatabaseInstance = Room.databaseBuilder(
                        context.applicationContext,
                        AlbumPhotoDataBase::class.java, "album_photo_database"
                    )
                        .build()
                }
            }
        }

        return userDatabaseInstance
        }

    }

}