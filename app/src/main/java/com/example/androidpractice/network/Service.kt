package com.example.androidpractice.network

import com.example.androidpractice.model.AlbumPhoto
import retrofit2.http.GET

interface Service {

    @GET("photos")
    suspend fun getAlbumPhoto():List<AlbumPhoto>
}