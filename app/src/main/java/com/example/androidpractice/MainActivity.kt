package com.example.androidpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.androidpractice.adapter.ParentAdapter
import com.example.androidpractice.databinding.ActivityMainBinding
import com.example.androidpractice.model.AlbumPhotoUIObject
import com.example.androidpractice.utils.DataConverter
import com.example.androidpractice.utils.Resource
import com.example.androidpractice.viewmodel.AlbumViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private val converter = DataConverter()

    private val mViewModel by lazy {
        ViewModelProvider(this).get(AlbumViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //instantiate the resultData function
        mViewModel.getResultData()


        binding.apply {
            mViewModel.albumPhoto.observe(this@MainActivity) { result ->

                parentRV.apply {
                    adapter = ParentAdapter(result.data)
                    scrollToPosition(Integer.MAX_VALUE/2)
                }

                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                errorMessage.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                errorMessage.text = result.error?.localizedMessage
            }
//            mViewModel.resultData.observe(this@MainActivity){ resultData ->

            }
        }
    }
}