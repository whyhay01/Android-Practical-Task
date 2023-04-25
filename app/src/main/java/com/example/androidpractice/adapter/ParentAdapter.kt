package com.example.androidpractice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice.databinding.DisplayAlbumBinding
import com.example.androidpractice.model.AlbumPhotoUIObject

class ParentAdapter(private val albumPhotoUIObjects: List<AlbumPhotoUIObject>): RecyclerView.Adapter< ParentAdapter.ParentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val view = DisplayAlbumBinding.inflate(LayoutInflater.from(parent.context))
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val dataPosition = position % albumPhotoUIObjects.size
        val data: AlbumPhotoUIObject = albumPhotoUIObjects[dataPosition]
        holder.bindView(data)
    }

    override fun getItemCount(): Int = Integer.MAX_VALUE

    inner class ParentViewHolder(binding: DisplayAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val bind = binding

        fun bindView(bindingData: AlbumPhotoUIObject) {
            bind.apply {
                title.text = bindingData.title


                //Child recyclerView implementation
                pictureRv.apply {
                    val childAdapter = ChildAdapter(bindingData.albumPhotos)
                    layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = childAdapter
//                    adapter?.notifyItemMoved(0, bindingData.albumPhotos.size)
                    scrollToPosition(Integer.MAX_VALUE/2)
                }
            }

        }

    }
}