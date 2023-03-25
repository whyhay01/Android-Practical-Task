package com.example.androidpractice.repository

import android.content.Context
import androidx.room.withTransaction
import com.example.androidpractice.db.AlbumPhotoDao
import com.example.androidpractice.db.AlbumPhotoDataBase
import com.example.androidpractice.network.NetworkManager
import com.example.androidpractice.utils.DataConverter
import com.example.androidpractice.utils.networkBoundResource

class Repository(context: Context) {

    private val albumPhotoDao:AlbumPhotoDao

    private var albumPhotoDataBase: AlbumPhotoDataBase? = AlbumPhotoDataBase.getDatabaseInstance(context)

    init {

        albumPhotoDao = albumPhotoDataBase!!.albumPhotoDao()
    }

    private val service = NetworkManager.getService()

    fun getAlbumPhotos() = networkBoundResource(
        query = {
            albumPhotoDao.getAlbumPhotos()
        }, fetch = {
            service.getAlbumPhoto()
        },
        saveFetchResult = { albumPhotos ->
//            albumPhotoDataBase?.withTransaction {

                albumPhotoDao.deleteAlbumPhotos()
                albumPhotoDao.insertAlbumPhotos(albumPhotos)

//            }
        },
//        shouldFetch = {userInDB ->
//            userInDB.isEmpty()
//
//        }

    )

}