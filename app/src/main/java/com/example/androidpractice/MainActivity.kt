package com.example.androidpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.androidpractice.adapter.ParentAdapter
import com.example.androidpractice.databinding.ActivityMainBinding
import com.example.androidpractice.model.AlbumPhotoUIObject
import com.example.androidpractice.utils.DataConverter
import com.example.androidpractice.utils.Resource
import com.example.androidpractice.viewmodel.AlbumViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val converter = DataConverter()

    private val mViewModel by lazy {
        ViewModelProvider(this).get(AlbumViewModel::class.java)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //instantiate the resultData function

        binding.apply {

            mViewModel.albumPhoto.observe(this@MainActivity) { result ->

                parentRV.apply {
                    if (result is Resource.Success || result.data != null){
                    val resultData = converter.convertData(result?.data)
                    adapter = ParentAdapter(resultData)
                    scrollToPosition(Integer.MAX_VALUE / 2)
                    }
                }

//This is where the error is handled
                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                errorMessage.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                errorMessage.text = result?.error?.localizedMessage
            }
        }
    }
}