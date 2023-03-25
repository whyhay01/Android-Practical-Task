package com.example.androidpractice.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.androidpractice.model.AlbumPhoto
import com.example.androidpractice.repository.Repository
import com.example.androidpractice.utils.Resource
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class AlbumViewModel(application: Application):AndroidViewModel(application) {

    private val repo = Repository(application)
    private val _resultData: MutableLiveData<Resource<List<AlbumPhoto>>> = MutableLiveData()
    val resultData: LiveData<Resource<List<AlbumPhoto>>>
        get() = _resultData

    val albumPhoto: LiveData<Resource<List<AlbumPhoto>>> = repo.getAlbumPhotos().asLiveData()

//    fun  getResultData(){
//        viewModelScope.launch{
//            val deferred = viewModelScope.async {
//                repo.getAlbumPhotos()
//            }
//                deferred.await().collect{
//                    _resultData.value = it
//                }
//        }
//    }
}