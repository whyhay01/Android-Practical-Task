package com.example.androidpractice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.*
import com.example.androidpractice.repository.Repository

class AlbumViewModel(application: Application):AndroidViewModel(application) {

    private val repo = Repository(application)

    val albumPhoto = repo.getAlbumPhotos().asLiveData()
}