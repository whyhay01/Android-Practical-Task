package com.example.androidpractice.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.androidpractice.model.AlbumPhotoUIObject
import com.example.androidpractice.repository.Repository
import com.example.androidpractice.utils.DataConverter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AlbumViewModel(application: Application):AndroidViewModel(application) {

    private val repo = Repository(application)
    private val _resultData: MutableLiveData<List<AlbumPhotoUIObject>> = MutableLiveData()
    val resultData: LiveData<List<AlbumPhotoUIObject>>
        get() = _resultData

    val albumPhoto = repo.getAlbumPhotos().asLiveData()

    fun  getResultData(){
        viewModelScope.launch{
            delay(8000)
            repo.getAlbumPhotos().collect{
                _resultData.value = DataConverter().convertData(it.data)
            }
        }
    }
}