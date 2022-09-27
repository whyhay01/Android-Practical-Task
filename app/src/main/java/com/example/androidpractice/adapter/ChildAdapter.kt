package com.example.androidpractice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.androidpractice.R
import com.example.androidpractice.databinding.DisplayPicturesBinding
import com.example.androidpractice.model.AlbumPhoto

class ChildAdapter(private val albumPhoto: List<AlbumPhoto>) :
    RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = DisplayPicturesBinding.inflate(LayoutInflater.from(parent.context))
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val dataPosition = position % albumPhoto.size
        val bindingData: AlbumPhoto = albumPhoto[dataPosition]
        holder.bindView(bindingData)

    }

    override fun getItemCount(): Int = Integer.MAX_VALUE

    inner class ChildViewHolder(binding: DisplayPicturesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val bind = binding

        fun bindView(bindingData: AlbumPhoto) {
            bind.apply {
                displayImage.load(bindingData.imageUrl) {
                    error(R.drawable.ic_baseline_error_outline_24)
                    placeholder(R.drawable.image_four)
                    size(150, 150)
                }
            }
        }
    }
}